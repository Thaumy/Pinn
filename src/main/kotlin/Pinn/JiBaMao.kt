package Pinn

import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.contact.Contact.Companion.sendImage
import net.mamoe.mirai.message.data.*
import java.io.File
import java.time.LocalTime


object JiBaMao {
    init {
        BotSender.Bot.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
            val nick = event.sender.nick
            val content = event.message.content
            if (LocalTime.now().hour in 2..5 && Util.PR(60)) {
                subject.sendImage(File("img/jibamao.jpg"))
            }
        }
    }
}