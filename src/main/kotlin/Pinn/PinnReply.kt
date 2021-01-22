package Pinn;

import com.alibaba.fastjson.JSON
import net.mamoe.mirai.Bot
import net.mamoe.mirai.BotFactory
import net.mamoe.mirai.alsoLogin
import net.mamoe.mirai.contact.Contact.Companion.sendImage
import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.*
import net.mamoe.mirai.utils.BotConfiguration
import org.apache.commons.io.FileUtils
import java.io.File

object PinnReply {
    init {
        BotSender.Bot.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
            val nick = event.sender.nick
            val content = event.message.content
            if (event.group.id == BotSender.Univer.id) {
                if ((content.contains("小品")
                    || content.contains("pinn")
                    || content.contains("Pinn"))
                    && content != ">pinn"
                ) {
                    if (Util.PR(10)) {
                        subject.sendImage(java.io.File("called.gif"))
                    } else if (Util.PR(70)) {
                        subject.sendMessage("?")
                    }
                }
            }
        }
    }
}

