package Pinn.Core

import java.io.File
import kotlinx.coroutines.runBlocking

import net.mamoe.mirai.Bot
import net.mamoe.mirai.BotFactory
import net.mamoe.mirai.alsoLogin
import net.mamoe.mirai.contact.Contact.Companion.sendImage
import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.message.data.Message
import net.mamoe.mirai.utils.BotConfiguration


object Bot {
    val Instance = login()
    val UniverGroup = Instance.getGroup(Config.univerID)

    fun login(): Bot {
        return runBlocking {
            BotFactory.newBot(Config.qqUsr, Config.qqPwd) {
                fileBasedDeviceInfo()
                protocol = BotConfiguration.MiraiProtocol.ANDROID_PHONE
            }.alsoLogin()
        }
    }

    //发送文本
    suspend fun Group.send(content: String) {
        this.sendMessage(content)
    }

    //发送图片
    suspend fun Group.send(content: File) {
        this.sendImage(content)
    }

    //发送消息
    suspend fun Group.send(content: Message) {
        this.sendMessage(content)
    }
}