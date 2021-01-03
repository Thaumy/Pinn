package Pinn;

import net.mamoe.mirai.Bot
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.*

class BotSender(val Bot: Bot, val melon_socie_id: Long, val melon_univer_id: Long) {
    val Socie = Bot.getGroup(melon_socie_id)
    val Univer = Bot.getGroup(melon_univer_id)

    var can_to_socie = false//转发到水瓜社
    var can_to_univer = false//转发到大学
    var anonymous_to_univer = true//匿名转发到大学

    val instruList = listOf("/*", "*/", "-v", "-x", "v?", "x?")

    fun instruCheck(msg: String): Boolean {
        for (el in instruList) {
            if (msg.contains(el)) {
                return false
            }
        }
        return true
    }

    suspend fun toSocie(event: GroupMessageEvent) {
        val nick = event.sender.nick
        val content = event.message.content
        if (can_to_socie && instruCheck(content))
            when (true) {
                content.contains("[图片]") -> Socie?.sendMessage(PlainText("$nick:").plus(event.message))
                else -> Socie?.sendMessage("$nick:$content")
            }


    }

    suspend fun toUniver(event: GroupMessageEvent) {
        val nick = event.sender.nick
        val content = event.message.content
        if (can_to_univer && instruCheck(content))
            when (true) {
                content.contains("[图片]") -> when (anonymous_to_univer) {
                    false -> Univer?.sendMessage(PlainText("$nick:").plus(event.message))
                    true -> Univer?.sendMessage(event.message)
                }
                else -> when (anonymous_to_univer) {
                    false -> Univer?.sendMessage("$nick:$content")
                    true -> Univer?.sendMessage(content)
                }
            }


    }
}

