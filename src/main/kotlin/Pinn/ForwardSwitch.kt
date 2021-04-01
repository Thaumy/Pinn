package Pinn

import Pinn.BotSender.isPinnCommand
import Pinn.BotSender.isSocieId
import Pinn.BotSender.isUniverId
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.*


object ForwardSwitch {
    init {
        BotSender.Bot.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
            val content = event.message.content
            //此处的isPinnCommand仅优化性能，减少判断，非必要
            if (event.group.id.isSocieId() && content.isPinnCommand()) {
                when {
                    content.contains("*)") -> {
                        BotSender.can_to_univer = true
                        subject.sendMessage("启用")
                    }
                    content.contains("(*") -> {
                        BotSender.can_to_univer = false
                        subject.sendMessage("不转啦！！！")
                    }
                    content.contains(">>") -> {
                        BotSender.can_to_socie = true
                        BotSender.toUniverString(content.replace(">>", ""))
                        BotSender.can_to_socie = false
                    }
                    content.contains(">接收") -> {
                        BotSender.can_to_socie = true
                        subject.sendMessage("启用")
                    }
                    content.contains(">拒收") -> {
                        BotSender.can_to_socie = false
                        subject.sendMessage("拒收消息")
                    }
                    content.contains(">匿名转发") -> {
                        BotSender.anonymous_to_univer = true
                        subject.sendMessage("启用")
                    }
                    content.contains(">实名转发") -> {
                        BotSender.anonymous_to_univer = false
                        subject.sendMessage("转发将实名")
                    }
                    else -> {
                        subject.sendMessage("未找到命令")
                    }
                }
            }
        }
    }
}