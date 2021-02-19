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
            val nick = event.sender.nick
            val content = event.message.content
            if (LocalTime.now().hour in 2..5 && 2.random()) {
                subject.sendImage(File("img/jibamao.jpg"))
            }
            if (LocalTime.now().hour in 23..24 && 3.random()) {
                subject.sendImage(File("img/heng.jpg"))
            }
        }
    }
}