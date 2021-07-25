package Pinn.Mod


import java.text.SimpleDateFormat
import java.util.*

import MySqlManager.MySqlConnMsg
import MySqlManager.MySqlManager
import Pinn.Core.Bot
import Pinn.Core.Config
import Pinn.Util.String.isPureText
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.content

object Learning {
    val connMsg = MySqlConnMsg("localhost", 3306, Config.dbUsr, Config.dbPwd)
    val manager = MySqlManager(connMsg, "pinn")

    init {
        Bot.Instance.eventChannel.subscribeAlways<GroupMessageEvent> { e ->

            if (e.message.content.isPureText()) {
                val sender_nick = e.sender.nick
                val sender_id = e.sender.id
                val group_id = e.group.id
                val content = e.message.content

                val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                val time = format.format(Date())

                manager.DoInConnection { conn ->
                    conn.createStatement().execute(
                        """INSERT INTO historia (sender_nick,sender_id,time,content,group_id) 
                            VALUES ('${sender_nick}','${sender_id}','${time}','${content}','${group_id}')""".trimMargin()
                    )
                }
            }
        }
    }
}