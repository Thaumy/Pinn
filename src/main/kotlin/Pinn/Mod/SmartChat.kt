package Pinn.Mod

import MySqlManager.MySqlConnMsg
import MySqlManager.MySqlManager
import Pinn.Core.Bot
import Pinn.Core.Config
import Pinn.Util.String.alike
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.content

object SmartChat {

    val connMsg = MySqlConnMsg("localhost", 3306, Config.dbUsr, Config.dbPwd)
    val manager = MySqlManager(connMsg, "pinn")
    val msgcache = mutableListOf<String>()

    init {
        Bot.Instance.eventChannel.subscribeAlways<GroupMessageEvent> { e ->
            val content = e.message.content
            val table = manager.GetTable("SELECT content FROM historia ORDER BY time DESC LIMIT 200,100")

            for ((i, el) in table.withIndex()) {
                val msg = el.get(0).toString()

                if (content.alike(msg) > 60) {
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


}