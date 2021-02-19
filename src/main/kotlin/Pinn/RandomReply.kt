package Pinn;

import net.mamoe.mirai.contact.Contact.Companion.sendImage
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.*
import Pinn.Util.random

object RandomReply {
    init {
        BotSender.Bot.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
            val nick = event.sender.nick
            val content = event.message.content
            if (event.group.id == BotSender.Univer.id) {
                if (100.random()) {
                    subject.sendImage(java.io.File("img/hug.jpg"))
                } else if (1000.random()) {
                    subject.sendImage(java.io.File("img/kiss.gif"))
                }
            }
        }
    }
}

