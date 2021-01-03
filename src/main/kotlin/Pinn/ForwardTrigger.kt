package Pinn

import net.mamoe.mirai.Bot
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.*

class ForwardTrigger(private val BotSender: BotSender) {
    fun open() {
        BotSender.Bot.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
            if (event.group.id == BotSender.melon_socie_id) {
                BotSender.toUniver(event)
            }
            if (event.group.id == BotSender.melon_univer_id) {
                BotSender.toSocie(event)
            }
        }
    }
}