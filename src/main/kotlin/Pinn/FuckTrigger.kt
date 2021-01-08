package Pinn

import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.contact.Contact.Companion.sendImage
import net.mamoe.mirai.message.data.*
import java.io.File

object FuckTrigger {
    init {
        BotSender.Bot.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
            val nick = event.sender.nick
            val content = event.message.content
            if (content.contains("sb") || content.contains("比划比划") || content.contains("老逼登")
            ) {
                subject.sendImage(File("bihuagou.jpg"))
            }
        }
    }
}