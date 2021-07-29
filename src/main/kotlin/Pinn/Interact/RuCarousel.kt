package Pinn.Interact

import Pinn.Core.Bot
import Pinn.Mod.Mute.mute
import Pinn.Util.Random.random

import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.content


object RuCarousel {
    private var times = 0
    private val init_ammo = 6//初始子弹数
    private var now_ammo = init_ammo//当前子弹数

    init {
        Bot.Instance.eventChannel.subscribeAlways<GroupMessageEvent> { e ->

            val content = e.message.content
            val sender_id = e.sender.id
            val subject = e.subject

            if (content == "/fire") {
                if (now_ammo.random()) {
                    if (Bot.UniverGroup?.mute(sender_id, now_ammo * 60) == true) {
                        subject.sendMessage("死了啦，拜托")
                        subject.sendMessage("reloading")
                    } else {
                        subject.sendMessage("靠，六级甲打不透")
                    }
                    now_ammo = init_ammo
                } else {
                    now_ammo--
                    subject.sendMessage("哑弹！剩余${now_ammo}颗子弹。")
                }
            }
        }
    }
}