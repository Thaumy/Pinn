package Pinn

import Pinn.BotSender.isUniverId
import Pinn.Util.random
import net.mamoe.mirai.contact.Contact.Companion.sendImage
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.content
import kotlinx.coroutines.*

object Mute {
    val reg_mute = Regex("@[0-9]* @[0-9]* 禁言")
    val reg_id = Regex("@[0-9]* ")
    var mute_id = 0L
    var times = 0
    val list = mutableListOf<Long>()
    var roulette_ammo = 16//初始子弹数

    init {
        BotSender.msgIsUniver { event ->
            runBlocking {

                val content = event.message.content
                val sender_id = event.sender.id
                val subject = event.subject

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
                        if (roulette_ammo.random()) {
                            BotSender.setUniverMute(sender_id, roulette_ammo * 60)
                            subject.sendMessage("哈哈哈哈哈哈哈哈哈哈哈")
                            subject.sendMessage("reloading！")
                            roulette_ammo = 16
                        } else {
                            roulette_ammo--
                            subject.sendMessage("哑弹！剩余${roulette_ammo}颗子弹。")
                        }
                    } catch (e: Throwable) {
                    }
                }
            }
        }
    }
}