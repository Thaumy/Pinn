package Pinn.Util

import kotlin.String

object String {
    //是否污秽语言
    fun String.isRudely(): Boolean {
        val rudeList = listOf(
            "cnm", "sb", "比划", "滚", "爬", "傻逼", "rbq", "操", "你妈", "草", "nmsl", "nm", "lbd", "xbzz"
        )
        for (el in rudeList)
            if (this.contains(el.toLowerCase()))
                return true
        return false
    }

    //是否呼叫机器人
    fun String.isCallPinn(): Boolean {
        val rudeList = listOf(
            "小品", "pinn", "Pinn"
        )
        for (el in rudeList)
            if (this.contains(el.toLowerCase()))
                return true
        return false
    }
}