package Pinn

import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.*

class ForwardSwitchTrigger(private val BotSender: BotSender) {
    fun open() {
        BotSender.Bot.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
            val nick = event.sender.nick
            val content = event.message.content
            if (event.group.id == 917328480L) {
                when (content) {
                    "/*" -> {
                        BotSender.can_to_univer = false
                        subject.sendMessage("不转啦！")
                    }
                    "*/" -> {
                        BotSender.can_to_univer = true
                        subject.sendMessage("那边能听到了哟~！")
                    }
                    "8=(" -> {
                        BotSender.can_to_socie = true
                        subject.sendMessage("消息可以进来哟~！")
                    }
                    "8===> *(" -> {
                        BotSender.can_to_socie = false
                        subject.sendMessage("拔出来了呢。。。")
                    }
                }
            }
        }
    }
}