package Pinn

import MySqlManager.MySqlConnMsg
import MySqlManager.MySqlManager
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.content

object SmartChat {
    val connMsg = MySqlConnMsg("localhost", 3306, "root", "65a1561425f744e2b541303f628963f8")
    val msm = MySqlManager(connMsg, "pinn")
    val msgcache = mutableListOf<String>()

    init {
        BotSender.Bot.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
            val content = event.message.content
            val table = msm.GetTable("SELECT content FROM historia ORDER BY time DESC LIMIT 200,100")
            for ((i, el) in table.withIndex()) {
                val msg = el.get(0).toString()
                //subject.sendMessage(msgAlikeRate(content, msg).toString())
                if (msgAlikeRate(content, msg) > 60) {
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

    private fun msgAlikeRate(msg1: String, msg2: String): Int {
        var head = 0
        //循环小
        for (c1 in if (msg1.length <= msg2.length) msg1 else msg2) {
            //循环大
            for (c2 in if (msg1.length > msg2.length) msg1 else msg2) {
                if (c1 == c2) {
                    head++
                }
            }
        }
        //除以最两者最少的字数
        return ((head.toDouble() / if (msg1.length < msg2.length) msg1.length else msg2.length) * 100).toInt()
    }
}