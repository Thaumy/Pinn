package Pinn.Interact

import Pinn.Core.Bot
import Pinn.Core.Bot.send
import Pinn.Util.Random.rand

import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.content


object MiyabiDetect {
    //雅子检测
    private var miyabi = 0.1

    init {
        Bot.Instance.eventChannel.subscribeAlways<GroupMessageEvent> { e ->
            val sender_id = e.sender.id
            if (sender_id == 2311546114) {
                rand(miyabi) {
                    subject.sendMessage("雅子！")
                }
            }
        }

        Bot.Instance.eventChannel.subscribeAlways<GroupMessageEvent> { e ->

            val content = e.message.content

            if (content.contains("/rate")) {
                when {
                    content.contains("miyabi") -> {
                        miyabi = content.replace("/rate miyabi", "").toDouble()
                        subject.sendMessage("雅子检测概率：${miyabi} (default0.1)")
                    }
                }
            }
        }
    }
}