package Pinn.Interact

import Pinn.Core.Bot
import Pinn.Core.Bot.UniverGroup
import Pinn.Core.Bot.send
import Pinn.Util.File.img
import Pinn.Util.Random.random
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.File
import java.time.LocalTime
import java.util.*

object GetUp {
    //起床任务
    private val getUpTask = object : TimerTask() {
        override fun run() {
            runBlocking {
                3.random({
                    UniverGroup?.send("早上好！")
                }, {
                    UniverGroup?.send("哦哈哟~！")
                })
                UniverGroup?.send(img("img/getUp.jpg"))
            }
        }
    }

    init {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)

        var getUpDay = calendar.get(Calendar.DAY_OF_MONTH)
        val getUpTime = Calendar.getInstance()

        //超出目标时间的日期补偿
        if (LocalTime.now().hour >= 7) {
            getUpDay++
        }

        getUpTime.set(year, month, getUpDay, 7, 0)

        Timer().schedule(getUpTask, getUpTime.time, 24 * 60 * 60 * 1000)//早上好定时任务
    }
}