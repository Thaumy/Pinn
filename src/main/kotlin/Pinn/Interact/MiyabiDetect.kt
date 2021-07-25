package Pinn.Interact

import Pinn.Core.Bot
import Pinn.Util.Random.random
import Pinn.Util.String.isPureText
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.content
import java.text.SimpleDateFormat
import java.util.*

object MiyabiDetect {//雅子检测
init {
    Bot.Instance.eventChannel.subscribeAlways<GroupMessageEvent> { e ->
        if (e.sender.id == 2311546114) {
            if (10.random()) {
                subject.sendMessage("雅子！")
            }
        }
    }
}
}