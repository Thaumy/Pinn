package Pinn

import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.contact.Contact.Companion.sendImage
import net.mamoe.mirai.message.data.*

import Pinn.Util.img
import Pinn.Util.isRudely


object BiHuaGou {
    init {
        BotSender.Bot.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
            val nick = event.sender.nick
            val content = event.message.content
            if (content.isRudely()) {
                Util.PR(30) { subject.sendImage(img("bihuagou.jpg")) }
            }
        }
    }
}