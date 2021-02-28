package Pinn

import Pinn.BotSender.isUniverId
import Pinn.Util.random
import net.mamoe.mirai.contact.Contact.Companion.sendImage
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.content

object Mute {
    val reg_mute = Regex("@[0-9]* @[0-9]* 禁言")
    val reg_id = Regex("@[0-9]* ")
    var mute_id = 0L
    var times = 0
    val list = mutableListOf<Long>()
    var dzp_ratecount = 32

    init {
        BotSender.Bot.eventChannel.subscribeAlways<GroupMessageEvent> { event ->
            val content = event.message.content
            val sender_id = event.sender.id
            val group_id = event.group.id

            if (group_id.isUniverId()) {
                if (reg_mute.containsMatchIn(content)) {
                    if (list.count() == 0) {
                        mute_id = reg_id.find(content)?.value.toString().let { it.substring(1, it.length - 1) }.toLong()
                        list.add(sender_id)
                        times++
                        subject.sendMessage("还差${2 - times}票通过")
                    } else {
                        subject.sendMessage("上一投票未结束！")
                    }
                } else if (content == "赞成") {
                    if (!list.contains(sender_id)) {//投票列表未包含
                        list.add(sender_id)
                        times++
                        if (times != 2) {
                            subject.sendMessage("还差${2 - times}票通过")
                        }
                    } else {
                        subject.sendMessage("您已经投过票了")
                    }
                    if (times == 2) {
                        list.clear()
                        BotSender.setUniverMute(mute_id)
                        mute_id = 0L
                        times = 0
                    }
                } else if (content == "开火！") {
                    try {
                        if (dzp_ratecount.random()) {
                            BotSender.setUniverMute10(sender_id)
                            subject.sendMessage("哈哈哈哈哈哈哈哈哈")
                            subject.sendMessage("reloading！")
                            dzp_ratecount = 32
                        } else {
                            dzp_ratecount--
                            subject.sendMessage("哑弹！剩余${dzp_ratecount}颗子弹。")
                        }
                    } catch (e: Throwable) {
                    }
                }
            }
        }
    }
}