package Pinn.Interact

import java.time.LocalTime

import Pinn.Core.Bot
import Pinn.Util.File.img
import Pinn.Util.Random.random

import net.mamoe.mirai.contact.Contact.Companion.sendImage
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.content


object JbCat {//几把猫
init {
    Bot.Instance.eventChannel.subscribeAlways<GroupMessageEvent> { e ->
        if (e.message.content == "/jbmao") {
            subject.sendImage(img("jibamao.jpg"))
            print("ss")
        }
        if (LocalTime.now().hour in 2..4 && 2.random()) {
            subject.sendImage(img("jibamao.jpg"))
        } else if (LocalTime.now().hour in 0..1 && 3.random()) {
            subject.sendImage(img("heng.jpg"))
        }
    }
}
}