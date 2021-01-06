package Pinn

import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.*

object MiyabiTrigger {
    var yazi_counter = 0;
    fun open() {
        BotSender.Bot.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
            val nick = event.sender.nick
            val content = event.message.content
            if (content.contains("。") && event.sender.id == 2311546114) {
                if (yazi_counter < 3) {
                    yazi_counter++
                } else {
                    yazi_counter = 0
                    subject.sendMessage("雅子！")
                }
            }
        }
    }
}