package thaumy.cn

import kotlinx.coroutines.runBlocking
import net.mamoe.mirai.BotFactory
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.alsoLogin
import net.mamoe.mirai.Bot
import net.mamoe.mirai.contact.Contact.Companion.sendImage
import net.mamoe.mirai.event.events.MessageRecallEvent
import net.mamoe.mirai.message.data.*
import net.mamoe.mirai.utils.BotConfiguration.MiraiProtocol.ANDROID_PHONE
import java.io.File
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class BotSender(val Bot: Bot, val melon_socie_id: Long, val melon_univer_id: Long) {
    val Socie = Bot.getGroup(melon_socie_id)
    val Univer = Bot.getGroup(melon_univer_id)
    var can_to_socie = false
    var can_to_univer = false

    suspend fun toSocie(msg: String) {
        if (can_to_socie)
            Socie?.sendMessage(msg)
    }

    suspend fun toSocie(msg: Message) {
        if (can_to_socie)
            Socie?.sendMessage(msg)
    }

    suspend fun toUniver(msg: String) {
        if (can_to_univer)
            Univer?.sendMessage(msg)
    }

    suspend fun toUniver(msg: Message) {
        if (can_to_univer)
            Univer?.sendMessage(msg)
    }
}

fun main(args: Array<String>): Unit = runBlocking {
    val qqId = 
    val password = ""

    val Bot = BotFactory.newBot(qqId, password) {
        fileBasedDeviceInfo()
        protocol = ANDROID_PHONE
    }.alsoLogin()

    val sender = BotSender(Bot, 917328480L, 1164772054L)

    //sender.Socie?.sendMessage("小品已介入")
    //sender.Socie?.sendMessage("当前实例:转发禁用")
    //sender.Univer?.sendMessage("小品已介入")
    //sender.Univer?.sendMessage("当前实例:转发可用")
    Bot.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
        val nick = event.sender.nick
        val content = event.message.content
        var yazi_counter = 0;
        if (content.contains("。") && event.sender.id == 2311546114) {
            if (yazi_counter < 5) {
                yazi_counter++
            } else {
                yazi_counter = 0
                subject.sendMessage("雅子！")
            }
        }
        if (content.contains("操") || content.contains("你妈") || content.contains("我日") || content.contains("傻逼") || content.contains(
                "比划比划"
            )
        ) {
            sender.Univer?.sendImage(File("bihuagou.jpg"))
        }
        if (LocalTime.now().hour in 1..5) {
            sender.Univer?.sendImage(File("jibamao.jpg"))
        }
    }
    Bot.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
        val nick = event.sender.nick
        val content = event.message.content
        if (event.group.id == 917328480L) {
            when (content) {
                "/*" -> {
                    sender.can_to_univer = false
                    subject.sendMessage("不转啦！")
                }
                "*/" -> {
                    sender.can_to_univer = true
                    subject.sendMessage("那边能听到了哟~！")
                }
                "8=*(" -> {
                    sender.can_to_socie = true
                    subject.sendMessage("消息可以进来哟~！")
                }
                "8===> *(" -> {
                    sender.can_to_socie = false
                    subject.sendMessage("拔出来了呢。。。")
                }
                else -> when {
                    content.contains("[图片]") -> sender.toUniver(PlainText("$nick:").plus(event.message))
                    else -> sender.toUniver("$nick:$content")
                }
            }
        } else if (event.group.id == 1164772054L) {
            if (content.contains("[图片]")) {
                sender.toSocie(PlainText("$nick:").plus(event.message))
            } else {
                sender.toSocie("$nick:$content")
            }
        }
    }
    Bot.join()
}

