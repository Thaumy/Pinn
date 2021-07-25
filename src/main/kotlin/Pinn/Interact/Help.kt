package Pinn.Interact

import Pinn.Core.Bot

import net.mamoe.mirai.message.data.content
import net.mamoe.mirai.event.events.GroupMessageEvent

import com.alibaba.fastjson.JSON
import org.apache.commons.io.FileUtils


object Help {
    private val file = java.io.File(".pinn/help.json")
    private val text = FileUtils.readFileToString(file, "UTF-8")
    private val config = JSON.parseObject(text)

    init {
        Bot.Instance.eventChannel.subscribeAlways<GroupMessageEvent> { e ->
            if (e.message.content == "/help") {
                var str = ""
                for (el in config) {
                    str += "${el.key} # ${el.value}\n"
                }
                subject.sendMessage(str)
            }
        }
    }
}