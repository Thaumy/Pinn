package Pinn.Interact

import MySqlManager.MySqlConnMsg
import MySqlManager.MySqlManager
import Pinn.Core.Bot
import Pinn.Core.Bot.UniverGroup
import Pinn.Core.Bot.send
import Pinn.Core.Config
import Pinn.Util.Random.random
import Pinn.Util.String.alike
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.content

object SmartChat {

    val connMsg = MySqlConnMsg("localhost", 3306, Config.dbUsr, Config.dbPwd)
    val manager = MySqlManager(connMsg, "pinn")
    val msgcache = mutableListOf<String>()

    var reply = 1.0//越大越不易触发
    var alike = 0.8//越大越不易触发

    init {
        Bot.Instance.eventChannel.subscribeAlways<GroupMessageEvent> { e ->

            (reply * 10).toInt().random {

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