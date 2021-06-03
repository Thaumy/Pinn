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

    lateinit var Bot: Bot
    lateinit var Socie: Group
    lateinit var Univer: Group

    var can_to_socie = false//转发到水瓜社
    var can_to_univer = false//转发到大学
    var anonymous_to_univer = true//匿名转发到大学

    val qid = (Config.pinnNode["qid"] as String).toLong()
    val pwd = Config.pinnNode["pwd"] as String
    val melonID = (Config.groupsNode["melon_id"] as String).toLong()
    val univerID = (Config.groupsNode["univer_id"] as String).toLong()

    //初始化Bot
    suspend fun init() {
        Bot = BotFactory.newBot(qid, pwd) {
            fileBasedDeviceInfo()
            protocol = BotConfiguration.MiraiProtocol.ANDROID_PHONE
        }.alsoLogin()
        Socie = Bot.getGroup(melonID)!!
        Univer = Bot.getGroup(univerID)!!
    }

    //是否是对于小品的命令
    fun String.isPinnCommand(): Boolean {
        val commandList = listOf("*)", "(*", ">>", ">img", ">event", ">help", ">接收", ">拒收", ">匿名转发", ">实名转发")
        for (el in commandList) {
            if (this.contains(el))
                return true
        }
        return false
    }

    suspend fun toSocie(event: GroupMessageEvent) {
        val nick = event.sender.nick
        val content = event.message.content
        if (can_to_socie && !content.isPinnCommand())
            when (true) {
                content.contains("[图片]") -> Socie?.sendMessage(PlainText("$nick:").plus(event.message))
                else -> Socie?.sendMessage("$nick:$content")
            }
    }

    suspend fun toUniverImg(img: File) {
        Univer?.sendImage(img)
    }

    suspend fun toUniverString(msg: String) {
        Univer?.sendMessage(msg)
    }

    suspend fun toUniver(event: GroupMessageEvent) {
        val nick = event.sender.nick
        val content = event.message.content
        if (can_to_univer && !content.isPinnCommand())
            when {
                content.contains("[图片]") -> when (anonymous_to_univer) {
                    false -> Univer?.sendMessage(PlainText("$nick:").plus(event.message))
                    true -> Univer?.sendMessage(event.message)
                }
                !content.contains("[图片]") -> when (anonymous_to_univer) {
                    false -> Univer?.sendMessage("$nick:$content")
                    true -> Univer?.sendMessage(content)
                }
            }
    }

    fun msgIsUniver(todo: (GroupMessageEvent) -> Unit) {
        Bot.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
            if (event.group.id.isUniverId())
                todo(event)
        }
    }

    //大学禁言
    suspend fun setUniverMute(id: Long) {
        Univer.getMember(id)?.mute(60)
    }

    suspend fun setUniverMute(id: Long, sec: Int) {
        Univer.getMember(id)?.mute(sec)
    }

    fun Long.isSocieId(): Boolean {
        return this == Socie.id
    }

    fun Long.isUniverId(): Boolean {
        return this == Univer.id
    }
}

