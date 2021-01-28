package Pinn;

import net.mamoe.mirai.contact.Contact.Companion.sendImage
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.*
import MySqlManager.*

object PinnReply {
    init {
        val connMsg = MySqlConnMsg("localhost", 3306, "root", "65a1561425f744e2b541303f628963f8")
        val msm = MySqlManager(connMsg, "pinn")

        BotSender.Bot.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
            val nick = event.sender.nick
            val content = event.message.content
            if (event.group.id == BotSender.Univer.id) {
                if ((content.contains("小品")
                            || content.contains("pinn")
                            || content.contains("Pinn"))
                    && content != ">pinn"
                ) {
                    if (Util.PR(10)) {
                        subject.sendImage(java.io.File("img/called.gif"))
                    } else if (Util.PR(70)) {
                        subject.sendMessage("?")
                    }
                }
            }

            /*val table = msm.GetTable("SELECT content FROM historia")
            for ((i, el) in table.withIndex()) {
                if (msgAlikeRate(content, el.get(0).toString()) > 60) {
                    if (i + 1 < table.colsCount)
                        subject.sendMessage(table.getRow(i + 1).get(0).toString())
                    break
                }
            }*/
        }
    }

    fun msgAlikeRate(msg1: String, msg2: String): Int {
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

