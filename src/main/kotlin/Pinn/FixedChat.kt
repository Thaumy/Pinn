package Pinn

import net.mamoe.mirai.contact.Contact.Companion.sendImage
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.*
import net.mamoe.mirai.contact.getMember
import java.time.LocalTime
import java.io.File
import MySqlManager.*
import Pinn.BotSender.isUniverId
import Pinn.Util.img
import Pinn.Util.isCallPinn
import Pinn.Util.isRudely
import Pinn.Util.random

object FixedChat {
    init {
        BotSender.Bot.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
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
                        }
                        false -> when {
                            8.random() -> subject.sendImage(img("called.gif"))
                            3.random() -> subject.sendMessage("?")
                        }
                    }
                }

                //几把猫
                if (LocalTime.now().hour in 2..4 && 2.random()) {
                    subject.sendImage(File("img/jibamao.jpg"))
                } else if (LocalTime.now().hour in 0..1 && 3.random()) {
                    subject.sendImage(File("img/heng.jpg"))
                }

                //随机回复
                if (100.random()) {
                    subject.sendImage(java.io.File("img/hug.jpg"))
                } else if (1000.random()) {
                    subject.sendImage(java.io.File("img/kiss.gif"))
                }

                //雅子检测
                if (sender_id == 2311546114) {
                    if (16.random()) {
                        subject.sendMessage("雅子！")
                    }
                }

            }
        }
    }
}

