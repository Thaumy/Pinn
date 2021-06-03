package Pinn

import net.mamoe.mirai.contact.Contact.Companion.sendImage
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.*
import net.mamoe.mirai.contact.getMember
import java.time.LocalTime
import java.io.File
import MySqlManager.*
import Pinn.BotSender.isUniverId
import Pinn.Util.img
import Pinn.Util.isCallPinn
import Pinn.Util.isRudely
import Pinn.Util.random

object FixedChat {
    init {
        BotSender.Bot.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
            val sender_id = event.sender.id
            val group_id = event.group.id
            val content = event.message.content

            if (content.contains(">help")) {
                subject.sendMessage(
                    "全局命令:\n" +
                            "取得帮助 >help\n" +
                            "小品状态 >pinn\n" +
                            "事件列表 >event\n" +
                            "图片调试 >img [相对路径]\n" +
                            "仅在水瓜社可用的命令:\n\n" +
                            "关闭转发 (*\n" +
                            "启用转发 *)\n" +
                            "临时匿名转发 >>[文本消息]\n" +
                            "消息控制 >[接收/拒收]\n" +
                            "匿名控制 >[匿名/实名]转发"
                )
            }
            if (content.contains(">event")) {
                subject.sendMessage(
                    "雅子检测 [由雅子发言触发]\n" +
                            "早上好 [小品起床时触发]\n" +
                            "几把猫 [小品睡觉时触发]\n" +
                            "大声哭闹 [小品睡觉的正香时触发]\n" +
                            "比划比划 [小品被骂时触发]\n"
                )
            }
            if (group_id.isUniverId()) {
                //如果是在大学叫小品，且不是命令
                if (content.isCallPinn() && content != ">pinn") {
                    when (content.isRudely()) {
                        true -> try {
                            BotSender.Univer.getMember(sender_id)?.mute(60)
                            subject.sendImage(img("fuck.jpg"))
                        } catch (e: Throwable) {
                        }
                        false -> when {
                            8.random() -> subject.sendImage(img("called.gif"))
                            3.random() -> subject.sendMessage("?")
                        }
                    }
                }

                //几把猫
                if (LocalTime.now().hour in 2..4 && 2.random()) {
                    subject.sendImage(img("jibamao.jpg"))
                } else if (LocalTime.now().hour in 0..1 && 3.random()) {
                    subject.sendImage(img("heng.jpg"))
                }

                //随机回复
                if (100.random()) {
                    subject.sendImage(img("hug.jpg"))
                } else if (1000.random()) {
                    subject.sendImage(img("kiss.gif"))
                }

                //雅子检测
                if (sender_id == 2311546114) {
                    if (20.random()) {
                        subject.sendMessage("雅子！")
                    }
                }

                if (content == "jrjb") {
                    subject.sendImage(img("jrjb.jpg"))
                }
            }
        }
    }
}

