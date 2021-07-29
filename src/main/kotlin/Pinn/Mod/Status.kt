package Pinn.Mod

import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import Pinn.Core.Bot
import Pinn.Util.File.img

import net.mamoe.mirai.message.data.content
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.utils.ExternalResource.Companion.toExternalResource


object Status {
    init {
        val initTime = LocalDateTime.now()
        val format = DateTimeFormatter.ofPattern("yy/MM/dd-HH:mm")

        Bot.Instance.eventChannel.subscribeAlways<GroupMessageEvent> { e ->

            val timeSpan = Duration.between(initTime, LocalDateTime.now())

            if (e.message.content == "/pinn") {
                subject.sendMessage(
                    subject.uploadImage(img("called.gif").toExternalResource()).plus(
                        "start:${format.format(initTime)}\n" +
                                "up:${timeSpan.toHours()}"
                    )
                )
            }
        }
    }
}