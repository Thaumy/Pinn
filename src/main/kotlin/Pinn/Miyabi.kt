package Pinn

import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.*
import Pinn.Util.random

object Miyabi {
    init {
        BotSender.Bot.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
            val nick = event.sender.nick
            val content = event.message.content
            if (event.sender.id == 2311546114) {
                if (80.random()) {
                    subject.sendMessage("雅子！")
                }
            }
        }
    }
}