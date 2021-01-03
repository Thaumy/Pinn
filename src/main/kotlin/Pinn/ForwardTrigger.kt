package Pinn

import net.mamoe.mirai.Bot
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.*

class ForwardTrigger(private val BotSender: BotSender) {
    fun open() {
        BotSender.Bot.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
            val nick = event.sender.nick
            val content = event.message.content
            if (event.group.id == BotSender.melon_socie_id) {
                when (true) {
                    content.contains("[图片]") -> BotSender.toUniver(PlainText("$nick:").plus(event.message))
                    else -> BotSender.toUniver("$nick:$content")
                }
            }
            if (event.group.id == BotSender.melon_univer_id) {
                when (true) {
                    content.contains("[图片]") -> BotSender.toSocie(PlainText("$nick:").plus(event.message))
                    else -> BotSender.toSocie("$nick:$content")
                }
            }
        }
    }
}