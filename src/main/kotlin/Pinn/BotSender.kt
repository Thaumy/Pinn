package Pinn;

import com.alibaba.fastjson.JSON
import net.mamoe.mirai.Bot
import net.mamoe.mirai.BotFactory
import net.mamoe.mirai.alsoLogin
import net.mamoe.mirai.contact.Contact.Companion.sendImage
import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.contact.getMember
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.*
import net.mamoe.mirai.utils.BotConfiguration
import org.apache.commons.io.FileUtils
import java.io.File


object BotSender {
    val config = JSON.parseObject(FileUtils.readFileToString(File("config.json"), "UTF-8"))
    lateinit var Bot: Bot
    lateinit var Socie: Group
    lateinit var Univer: Group

    var can_to_socie = false//转发到水瓜社
    var can_to_univer = false//转发到大学
    var anonymous_to_univer = true//匿名转发到大学

    val instruList = listOf("/*", "*/", "-v", "-x", "v?", "x?")

    //初始化Bot
    suspend fun init() {
        Bot = BotFactory.newBot(config.getLong("pinn_id"), config.getString("pinn_pwd")) {
            fileBasedDeviceInfo()
            protocol = BotConfiguration.MiraiProtocol.ANDROID_PHONE
        }.alsoLogin()
        Socie = Bot.getGroup(config.getLong("melon_id"))!!
        Univer = Bot.getGroup(config.getLong("univer_id"))!!
    }

    fun instruCheck(msg: String): Boolean {
        for (el in instruList) {
            if (msg.contains(el)) {
                return false
            }
        }
        return true
    }

    suspend fun toSocie(event: GroupMessageEvent) {
        val nick = event.sender.nick
        val content = event.message.content
        if (can_to_socie && instruCheck(content))
            when (true) {
                content.contains("[图片]") -> Socie?.sendMessage(PlainText("$nick:").plus(event.message))
                else -> Socie?.sendMessage("$nick:$content")
            }
    }

    suspend fun toUniverImg(img: File) {
        Univer?.sendImage(img)
    }

    suspend fun toUniver(msg: String) {
        Univer?.sendMessage(msg)
    }

    suspend fun toUniver(event: GroupMessageEvent) {
        val nick = event.sender.nick
        val content = event.message.content
        if (can_to_univer && instruCheck(content))
            when (true) {
                content.contains("[图片]") -> when (anonymous_to_univer) {
                    false -> Univer?.sendMessage(PlainText("$nick:").plus(event.message))
                    true -> Univer?.sendMessage(event.message)
                }
                else -> when (anonymous_to_univer) {
                    false -> Univer?.sendMessage("$nick:$content")
                    true -> Univer?.sendMessage(content)
                }
            }
    }

    //大学禁言
    suspend fun setUniverMute(id: Long) {
        Univer.getMember(id)?.mute(60)
    }

    suspend fun setUniverMute(id: Long, sec: Int) {
        Univer.getMember(id)?.mute(sec)
    }

    fun Long.isUniverId(): Boolean {
        return this == Univer.id
    }
}

