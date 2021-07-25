package Pinn.Mod

import java.io.File
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import Pinn.Core.Bot
import Pinn.Util.File.img
import net.mamoe.mirai.contact.Contact.Companion.sendImage
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.content
import net.mamoe.mirai.utils.ExternalResource.Companion.toExternalResource

object Status {
    init {
        val initTime = LocalDateTime.now()
        val format = DateTimeFormatter.ofPattern("yy/MM/dd-HH:mm")
        Bot.Instance.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
            val timeSpan = Duration.between(initTime, LocalDateTime.now())
            if (event.message.content == ">pinn") {
                subject.sendMessage(
                    subject.uploadImage(img("called.gif").toExternalResource()).plus(
                        "build:${format.format(initTime)}\n" +
                                "upHour:${timeSpan.toHours()}\n"
                    )
                )
            }
        }
        Bot.Instance.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
            val content = event.message.content
            if (content.contains(">img")) {
                try {
                    subject.sendImage(File(content.replace(">img ", "")))
                } catch (e: Throwable) {
                    subject.sendMessage("没找到图片...")
                }
            }
        }
    }
}