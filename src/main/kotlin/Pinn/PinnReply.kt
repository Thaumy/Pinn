package Pinn

import net.mamoe.mirai.contact.Contact.Companion.sendImage
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.*
import net.mamoe.mirai.contact.getMember
import java.time.LocalTime
import java.io.File
import MySqlManager.*
import Pinn.BotSender.Bot
import Pinn.BotSender.isUniverId
import Pinn.Util.img
import Pinn.Util.isCallPinn
import Pinn.Util.isRudely
import Pinn.Util.random
import net.mamoe.mirai.contact.isMuted

object PinnReply {
    init {
        val connMsg = MySqlConnMsg("localhost", 3306, "root", "65a1561425f744e2b541303f628963f8")
        val msm = MySqlManager(connMsg, "pinn")
        val msgcache = mutableListOf<String>()
        BotSender.Bot.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
            val sender_nick = event.sender.nick
            val sender_id = event.sender.id
            val group_id = event.group.id
            val content = event.message.content
            if (group_id.isUniverId()) {

                //如果是在大学叫小品，且不是命令
                if (content.isCallPinn() && content != ">pinn") {
                    when (content.isRudely()) {
                        true -> try {
                            BotSender.Univer.getMember(sender_id)?.mute(60)
                            subject.sendImage(img("fuck.jpg"))
                        } catch (e: Throwable) {
                            subject.sendImage(img("kneel.gif"))
                        }
                        false -> if (Util.PR(10)) {
                            subject.sendImage(img("called.gif"))
                        } else if (Util.PR(70)) {
                            subject.sendMessage("?")
                        }
                    }
                }
                //几把猫
                if (LocalTime.now().hour in 2..4 && 2.random()) {
                    subject.sendImage(File("img/jibamao.jpg"))
                }
                if (LocalTime.now().hour in 0..1 && 3.random()) {
                    subject.sendImage(File("img/heng.jpg"))
                }

                //比划狗
                if (content.isRudely()) {
                    Util.PR(30) { subject.sendImage(img("bihuagou.jpg")) }
                }
                //随机回复
                if (100.random()) {
                    subject.sendImage(java.io.File("img/hug.jpg"))
                } else if (1000.random()) {
                    subject.sendImage(java.io.File("img/kiss.gif"))
                }


                val table = msm.GetTable("SELECT content FROM historia ORDER BY time DESC LIMIT 200,100")
                for ((i, el) in table.withIndex()) {
                    val msg = el.get(0).toString()
                    //subject.sendMessage(msgAlikeRate(content, msg).toString())
                    if (msgAlikeRate(content, msg) > 60) {
                        val msg2 = table.getRow(i + 1).get(0).toString()

                        var temp = false
                        for (el2 in msgcache) {
                            if (el2 == msg2)
                                temp = true
                        }
                        if (!temp) {
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

