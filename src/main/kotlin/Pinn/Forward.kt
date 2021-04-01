package Pinn

import Pinn.BotSender.isSocieId
import Pinn.BotSender.isUniverId
import net.mamoe.mirai.event.events.GroupMessageEvent


object Forward {
    init {
        BotSender.Bot.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
            if (event.group.id.isSocieId()) {
                BotSender.toUniver(event)
            }
            if (event.group.id.isUniverId()) {
                BotSender.toSocie(event)
            }
        }
    }
}