package Pinn

import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.contact.Contact.Companion.sendImage
import net.mamoe.mirai.message.data.*
import java.io.File
import java.time.LocalTime
import Pinn.Util.random

object JiBaMao {
    init {
        BotSender.Bot.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
            if (event.group.id == BotSender.Univer.id) {
                if (LocalTime.now().hour in 2..4 && 2.random()) {
                    subject.sendImage(File("img/jibamao.jpg"))
                }
                if (LocalTime.now().hour in 0..1 && 3.random()) {
                    subject.sendImage(File("img/heng.jpg"))
                }
            }
        }
    }
}