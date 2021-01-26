package Pinn

import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.*


object ForwardSwitch {
    init {
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
                    "-v" -> {
                        BotSender.can_to_socie = true
                        subject.sendMessage("接收消息")
                    }
                    "-x" -> {
                        BotSender.can_to_socie = false
                        subject.sendMessage("拒收消息")
                    }
                    "v?" -> {
                        BotSender.anonymous_to_univer = true
                        subject.sendMessage("匿名转发启用")
                    }
                    "x?" -> {
                        BotSender.anonymous_to_univer = false
                        subject.sendMessage("匿名转发关闭")
                    }
                }
            }
        }
    }
}