@file:Suppress("DEPRECATION")

package Pinn;

import com.alibaba.fastjson.JSON
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.mamoe.mirai.Bot
import net.mamoe.mirai.BotFactory
import net.mamoe.mirai.alsoLogin
import net.mamoe.mirai.contact.Contact.Companion.sendImage
import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.*
import net.mamoe.mirai.utils.BotConfiguration
import okhttp3.internal.notify
import org.apache.commons.io.FileUtils
import java.io.File
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.*
import java.util.Calendar


object Ohayo {
    init {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        var getUpDay = calendar.get(Calendar.DAY_OF_MONTH)
        var goBedDay = calendar.get(Calendar.DAY_OF_MONTH)

        val getUpTime = Calendar.getInstance()
        val goBedTime = Calendar.getInstance()

        //超出目标时间的日期补偿
        if (LocalTime.now().hour >= 7) {
            getUpDay++
        }
        if (LocalTime.now().hour >= 23) {
            goBedDay++
        }

        getUpTime.set(year, month, getUpDay, 7, 0)
        goBedTime.set(year, month, goBedDay, 23, 0)

        Timer().schedule(getUp, getUpTime.time, 24 * 60 * 60 * 1000)//早上好定时任务
        Timer().schedule(goBed, goBedTime.time, 24 * 60 * 60 * 1000)//晚安定时任务

    }
}

val getUp = object : TimerTask() {
    override fun run() {
        GlobalScope.launch {
            BotSender?.toUniver("米娜桑！哦哈哟~~")
        }
    }
}
val goBed = object : TimerTask() {
    override fun run() {
        GlobalScope.launch {
            BotSender?.toUniver("哦呀斯密...")
        }
    }
}
