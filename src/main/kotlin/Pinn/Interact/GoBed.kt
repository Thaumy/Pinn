package Pinn.Interact

import java.util.*
import java.time.LocalTime
import kotlinx.coroutines.runBlocking

import Pinn.Core.Bot.send
import Pinn.Util.File.img
import Pinn.Util.Random.random
import Pinn.Core.Bot.UniverGroup


object GoBed {
    //睡觉任务
    private val goBedTask = object : TimerTask() {
        override fun run() {
            runBlocking {
                3.random({
                    UniverGroup?.send("睡你妈。")
                    UniverGroup?.send(img("img/lai.jpg"))
                }, {
                    UniverGroup?.send("哦呀斯密~o(*≧▽≦)ツ┏━┓")
                    UniverGroup?.send(img("img/goBed.jpg"))
                })
            }
        }
    }

    init {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)

        var goBedDay = calendar.get(Calendar.DAY_OF_MONTH)
        val goBedTime = Calendar.getInstance()

        //超出目标时间的日期补偿
        if (LocalTime.now().hour >= 22) {
            goBedDay++
        }

        goBedTime.set(year, month, goBedDay, 22, 0)

        Timer().schedule(goBedTask, goBedTime.time, 24 * 60 * 60 * 1000)//晚安定时任务
    }
}