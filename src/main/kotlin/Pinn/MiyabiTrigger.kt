package Pinn

import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.*

object MiyabiTrigger {
    init {
        BotSender.Bot.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
            val nick = event.sender.nick
            val content = event.message.content
            if (content.contains("。") && event.sender.id == 2311546114) {
                if ((0..100).random() <= 20) {
                    subject.sendMessage("雅子！")
                }
            }
        }
    }
}