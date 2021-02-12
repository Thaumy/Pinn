package Pinn;

import net.mamoe.mirai.contact.Contact.Companion.sendImage
import net.mamoe.mirai.contact.getMember
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.content
import net.mamoe.mirai.utils.ExternalResource.Companion.toExternalResource
import java.io.File
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


object AdminMsg {
    init {
        val initTime = LocalDateTime.now()
        val format = DateTimeFormatter.ofPattern("yy/MM/dd-HH:mm")
        BotSender.Bot.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
            val timeSpan = Duration.between(initTime, LocalDateTime.now())
            if (event.message.content == ">pinn") {
                subject.sendMessage(
                    subject.uploadImage(File("img/called.gif").toExternalResource()).plus(
                        "build:${format.format(initTime)}\n" +
                                "upHour:${timeSpan.toHours()}\n" +
                                "SocieMsgCount:${Counter.SocieMsgCount}\n" +
                                "UniverMsgCount:${Counter.UniverMsgCount}"
                    )
                )
            }
        }
        BotSender.Bot.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
            val content = event.message.content
            if (content.contains(">img ") && event.sender.id == 1951327599L) {
                try {
                    subject.sendImage(File(content.replace(">img ", "")))
                } catch (e: Throwable) {
                    subject.sendMessage("没找到图片...")
                }
            }
        }

    }
}