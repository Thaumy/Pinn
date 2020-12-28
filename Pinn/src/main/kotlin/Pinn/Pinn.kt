package net.mamoe.mirai.simpleloader

import kotlinx.coroutines.*
import net.mamoe.mirai.BotFactory
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.alsoLogin
import net.mamoe.mirai.contact.Contact
import net.mamoe.mirai.event.subscribeAlways
import net.mamoe.mirai.message.data.content
import net.mamoe.mirai.newBot
import net.mamoe.mirai.utils.BotConfiguration.MiraiProtocol.ANDROID_PAD
import javax.naming.Context

suspend fun main() {
    val qqId = 2335306147L
    val password = "h2omelon405"
    val miraiBot = BotFactory.newBot(qqId, password) {
        fileBasedDeviceInfo()
        protocol = ANDROID_PAD
    }.alsoLogin()
    /*
    miraiBot.subscribeAlways<GroupMessageEvent> { event ->
        if (event.message.content=="呐~") {
            reply("!")
        } else {
            //val text=event.sender.nick+":\n"+event.message.content
            //quoteReply(text)
        }
        miraiBot.getGroup(1164772054L)?.sendMessage(event.sender.nick+":\n"+event.message.content)
    }
    */

    miraiBot.join()
}