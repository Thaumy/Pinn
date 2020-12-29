package thaumy.cn

import kotlinx.coroutines.runBlocking
import net.mamoe.mirai.BotFactory
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.alsoLogin
import net.mamoe.mirai.message.data.content
import net.mamoe.mirai.utils.BotConfiguration.MiraiProtocol.ANDROID_PHONE


fun main(args: Array<String>): Unit = runBlocking {
    val qqId = 
    val password = ""
    val miraiBot = BotFactory.newBot(qqId, password) {
        fileBasedDeviceInfo()
        protocol = ANDROID_PHONE
    }.alsoLogin()

    miraiBot.getGroup()?.sendMessage("小品已介入")
    miraiBot.getGroup()?.sendMessage("初始化模式:转发禁用")
    miraiBot.getGroup()?.sendMessage("小品已介入")
    miraiBot.getGroup()?.sendMessage("初始化模式:转发禁用")
    var lock = true
    miraiBot.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
        val msg = event.sender.nick + ":\n" + event.message.content
        if (event.group.id == ) {
            if (event.message.content == "/*") {
                lock = true
                subject.sendMessage("不转啦！")
            } else if (event.message.content == "*/" ) {
                lock = false
                subject.sendMessage("那边能听到了哟~！")
            } else if (!lock) {
                if (event.message.content == "[图片]") {
                    miraiBot.getGroup()?.sendMessage(event.sender.nick + ":")
                    miraiBot.getGroup()?.sendMessage(event.message)
                } else {
                    miraiBot.getGroup()?.sendMessage(msg)
                }
            }

        } else if (event.group.id == ) {
            if (event.message.content == "[图片]") {
                miraiBot.getGroup()?.sendMessage(event.sender.nick + ":")
                miraiBot.getGroup()?.sendMessage(event.message)
            } else {
                miraiBot.getGroup()?.sendMessage(msg)
            }
        }
    }

    miraiBot.join()
}

