package Pinn

import Pinn.Util.isRudely
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.contact.Contact.Companion.sendImage
import net.mamoe.mirai.message.data.*
import java.io.File


object BiHuaGou {
    init {
        BotSender.Bot.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
            val nick = event.sender.nick
            val content = event.message.content
            if (content.isRudely()) {
                Util.PR(30) { subject.sendImage(File("img/bihuagou.jpg")) }
            }
        }
    }
}