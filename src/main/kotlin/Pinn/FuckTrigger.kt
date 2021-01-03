package Pinn

import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.contact.Contact.Companion.sendImage
import net.mamoe.mirai.message.data.*
import java.io.File

class FuckTrigger(private val BotSender: BotSender) {
    fun open() {
        BotSender.Bot.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
            val nick = event.sender.nick
            val content = event.message.content
            if (content.contains("操") || content.contains("你妈") || content.contains("我日") || content.contains("傻逼") || content.contains(
                    "比划比划"
                )
            ) {
                subject.sendImage(File("bihuagou.jpg"))
            }
        }
    }
}