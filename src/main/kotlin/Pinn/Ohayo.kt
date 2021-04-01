package Pinn;

import Pinn.Util.random
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
        if (LocalTime.now().hour >= 22) {
            goBedDay++
        }

        getUpTime.set(year, month, getUpDay, 7, 0)
        goBedTime.set(year, month, goBedDay, 22, 0)

        Timer().schedule(getUpTask, getUpTime.time, 24 * 60 * 60 * 1000)//早上好定时任务
        Timer().schedule(goBedTask, goBedTime.time, 24 * 60 * 60 * 1000)//晚安定时任务
    }
}

//起床任务
val getUpTask = object : TimerTask() {
    override fun run() {
        GlobalScope.launch {
            BotSender.run {
                3.random({
                    toUniverString("早上好！")
                }, {
                    toUniverString("哦哈哟~！")
                })
                toUniverImg(File("img/getUp.jpg"))
            }
        }
    }
}

//睡觉任务
val goBedTask = object : TimerTask() {
    override fun run() {
        GlobalScope.launch {
            BotSender.run {
                3.random({
                    toUniverString("睡你妈。")
                    toUniverImg(File("img/lai.jpg"))
                }, {
                    toUniverString("哦呀斯密~o(*≧▽≦)ツ┏━┓")
                    toUniverImg(File("img/goBed.jpg"))
                })
            }
        }
    }
}
