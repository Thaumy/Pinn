package net.mamoe.mirai.simpleloader

import kotlinx.coroutines.*
import net.mamoe.mirai.BotFactory
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.alsoLogin
import net.mamoe.mirai.contact.Contact
import net.mamoe.mirai.contact.Contact.Companion.sendImage
import net.mamoe.mirai.event.subscribeAlways
import net.mamoe.mirai.message.data.MessageChain
import net.mamoe.mirai.message.data.content
import net.mamoe.mirai.message.data.source
import net.mamoe.mirai.newBot
import net.mamoe.mirai.utils.BotConfiguration.MiraiProtocol.ANDROID_PHONE

class Demo {
    companion object {
        @JvmStatic
        suspend fun main(args: Array<String>) {
            val qqId = 2335306147L
            val password = ""
            val miraiBot = BotFactory.newBot(qqId, password) {
                fileBasedDeviceInfo()
                protocol = ANDROID_PHONE
            }.alsoLogin()

            miraiBot.getGroup(917328480L)?.sendMessage("小品已介入")
            miraiBot.getGroup(917328480L)?.sendMessage("初始化模式:转发禁用")
            var lock = true
            miraiBot.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
                val msg = event.sender.nick + ":\n" + event.message.content
                if (event.group.id == 917328480L) {
                    if (event.message.content == "/*") {
                        lock = true
                        subject.sendMessage("不转啦！")
                    } else if (event.message.content == "*/") {
                        lock = false
                        subject.sendMessage("那边能听到了哟~！")
                    } else if (!lock) {
                        if (event.message.content == "[图片]") {
                            miraiBot.getGroup(1164772054L)?.sendMessage(event.sender.nick + ":")
                            miraiBot.getGroup(1164772054L)?.sendMessage(event.message)
                        } else {
                            miraiBot.getGroup(1164772054L)?.sendMessage(msg)
                        }
                    }

                } else if (event.group.id == 1164772054L) {
                    if (event.message.content == "[图片]") {
                        miraiBot.getGroup(917328480L)?.sendMessage(event.sender.nick + ":")
                        miraiBot.getGroup(917328480L)?.sendMessage(event.message)
                    } else {
                        miraiBot.getGroup(917328480L)?.sendMessage(msg)
                    }
                } else {

                }
            }

            miraiBot.join()
        }
    }
}
