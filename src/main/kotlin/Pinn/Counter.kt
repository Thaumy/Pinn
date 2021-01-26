package Pinn;

import net.mamoe.mirai.event.events.GroupMessageEvent


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