package Pinn.Interact

import Pinn.Core.Bot
import Pinn.Util.File
import net.mamoe.mirai.contact.Contact.Companion.sendImage
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.content

object Help {
    init {
        Bot.Instance.eventChannel.subscribeAlways<GroupMessageEvent> { e ->
            if (e.message.content == "/help") {
                subject.sendMessage()
            }
        }
    }
}