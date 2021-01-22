package Pinn;

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.mamoe.mirai.contact.Contact.Companion.sendImage
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.content
import java.io.File
import java.time.Duration
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.*
import java.util.Calendar


object Counter {
    var SocieMsgCount: Int = 0
    var UniverMsgCount: Int = 0

    init {
        BotSender.Bot.eventChannel.subscribeAlways<GroupMessageEvent> { e ->
            if (e.group.id == BotSender.Socie.id)
                Counter.SocieMsgCount++
            if (e.group.id == BotSender.Univer.id)
                Counter.UniverMsgCount++
        }
    }
}