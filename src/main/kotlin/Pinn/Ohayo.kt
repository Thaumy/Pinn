package Pinn;

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.File
import java.time.LocalTime
import java.util.*


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

//起床任务
val getUp = object : TimerTask() {
    override fun run() {
        GlobalScope.launch {
            Util.PR(60, {
                BotSender?.toUniver("早上好！")
            }, {
                BotSender?.toUniver("哦哈哟~！")
            })
            BotSender?.toUniverImg(File("img/getUp.jpg"))
        }
    }
}

//睡觉任务
val goBed = object : TimerTask() {
    override fun run() {
        GlobalScope.launch {
            Util.PR(70, {
                BotSender?.toUniver("睡你妈。")
                BotSender?.toUniverImg(File("img/lai.jpg"))
            }, {
                BotSender?.toUniver("哦呀斯密~o(*≧▽≦)ツ┏━┓")
                BotSender?.toUniverImg(File("img/goBed.jpg"))
            })

        }
    }
}
