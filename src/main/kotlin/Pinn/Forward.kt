package Pinn

import net.mamoe.mirai.event.events.GroupMessageEvent


object Forward {
    init {
        BotSender.Bot.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
            if (event.group.id == BotSender.Socie?.id) {
                BotSender.toUniver(event)
            }
            if (event.group.id == BotSender.Socie?.id) {
                BotSender.toSocie(event)
            }
        }
    }
}