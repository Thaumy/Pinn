package Pinn

import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.*

class MiyabiTrigger(private val sender: BotSender) {
    var yazi_counter = 0;
    fun open() {
        sender.Bot.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
            val nick = event.sender.nick
            val content = event.message.content
            if (content.contains("。") && event.sender.id == 2311546114) {
                if (yazi_counter < 2) {
                    yazi_counter++
                } else {
                    yazi_counter = 0
                    subject.sendMessage("雅子！")
                }
            }
        }
    }
}