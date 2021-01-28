package Pinn;

import MySqlManager.MySqlConnMsg
import MySqlManager.MySqlManager
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.content
import java.text.SimpleDateFormat
import java.util.*


object Counter {
    var SocieMsgCount: Int = 0
    var UniverMsgCount: Int = 0

    val connMsg = MySqlConnMsg("localhost", 3306, "root", "65a1561425f744e2b541303f628963f8")
    val msm = MySqlManager(connMsg, "pinn")

    init {
        BotSender.Bot.eventChannel.subscribeAlways<GroupMessageEvent> { e ->
            if (e.group.id == BotSender.Socie.id)
                Counter.SocieMsgCount++
            if (e.group.id == BotSender.Univer.id) {
                Counter.UniverMsgCount++

                //学习功能，存储消息记录到数据库
                if (!e.message.content.contains("[图片]")) {
                    val sender_nick = e.sender.nick
                    val sender_id = e.sender.id
                    val content = e.message.content

                    val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    val time = sdf.format(Date())

                    msm.DoInConnection { conn ->
                        conn.createStatement().execute(
                            """INSERT INTO historia (sender_nick,sender_id,time,content) 
                            VALUES ('${sender_nick}','${sender_id}','${time}','${content}')""".trimMargin()
                        )
                    }
                }
            }
        }
    }
}