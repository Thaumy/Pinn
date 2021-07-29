package Pinn.Interact

import Pinn.Core.Bot
import Pinn.Core.Config
import Pinn.Core.Bot.send
import Pinn.Util.String.alike
import Pinn.Util.Random.random
import Pinn.Core.Bot.UniverGroup

import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.content

import MySqlManager.MySqlConnMsg
import MySqlManager.MySqlManager
import Pinn.Util.Random.rand


object SmartChat {
    private val connMsg = MySqlConnMsg("localhost", 3306, Config.dbUsr, Config.dbPwd)
    private val manager = MySqlManager(connMsg, "pinn")
    private val msgcache = mutableListOf<String>()

    private var reply = 1.0//越大越易触发
    private var alike = 0.8//越大越不易触发

    init {
        Bot.Instance.eventChannel.subscribeAlways<GroupMessageEvent> { e ->

            rand(reply) {

                val content = e.message.content
                val table = manager.GetTable("SELECT content FROM historia ORDER BY time DESC LIMIT 200,100")

                for ((i, el) in table.withIndex()) {
                    val msg = el.get(0).toString()

                    if (content.alike(msg) > alike) {
                        val msg2 = table.getRow(i + 1).get(0).toString()

                        var repeat = false
                        for (el2 in msgcache) {
                            if (el2 == msg2)
                                repeat = true
                        }
                        if (!repeat) {
                            subject.sendMessage(msg2)
                            msgcache.add(msg2)
                            if (msgcache.count() > 90) {
                                msgcache.clear()
                            }
                            break
                        }
                    }
                }
            }

        }

        Bot.Instance.eventChannel.subscribeAlways<GroupMessageEvent> { e ->
            val content = e.message.content
            if (content.contains("/rate")) {
                when {
                    content.contains("reply") -> {
                        reply = content.replace("/rate reply", "").toDouble()
                        UniverGroup?.send("回复概率：$reply (default1.0)")
                    }
                    content.contains("alike") -> {
                        alike = content.replace("/rate alike", "").toDouble()
                        UniverGroup?.send("相似率：$alike (default0.8)")
                    }
                }
            }
        }
    }
}