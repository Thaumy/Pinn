package Pinn

import Pinn.BotSender.isUniverId
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.content

object Mute {
    val reg_mute = Regex("@[0-9]* @[0-9]* 禁言")
    val reg_id = Regex("@[0-9]* ")
    var mute_id = 0L
    var times = 0
    val list = mutableListOf<Long>()

    init {
        BotSender.Bot.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
            val content = event.message.content
            val sender_id = event.sender.id
            val group_id = event.group.id

            if (group_id.isUniverId()) {

                if (reg_mute.containsMatchIn(content)) {
                    if (list.count() == 0) {
                        //mute_id = reg_id.matchEntire(content)?.value?.substring(1, -2)?.toLong()!!
                        subject.sendMessage(reg_id.matchEntire(content)?.value.toString())
                    } else {
                        subject.sendMessage("上一投票未结束！")
                    }

                } else if (content == "赞成") {
                    if (!list.contains(sender_id)) {
                        list.add(sender_id)
                        times++
                    }
                    if (times == 2) {
                        list.clear()
                        BotSender.setUniverMute(mute_id)
                        mute_id = 0L
                    }
                }
            }
        }
    }
}