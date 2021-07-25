package Pinn.Mod

import Pinn.Core.Bot
import Pinn.Mod.Mute.mute
import Pinn.Util.Random.random
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.content

object RuCarousel {
    var times = 0
    val init_ammo = 6//初始子弹数
    var now_ammo = init_ammo//当前子弹数

    init {
        Bot.Instance.eventChannel.subscribeAlways<GroupMessageEvent> { e ->

            val content = e.message.content
            val sender_id = e.sender.id
            val subject = e.subject

            if (content == "开火！") {
                if (now_ammo.random()) {
                    Bot.UniverGroup?.mute(sender_id, now_ammo * 60)
                    subject.sendMessage("哈哈哈哈哈哈哈哈哈哈哈")
                    subject.sendMessage("reloading！")
                    now_ammo = init_ammo
                } else {
                    now_ammo--
                    subject.sendMessage("哑弹！剩余${now_ammo}颗子弹。")
                }
            }
        }
    }
}