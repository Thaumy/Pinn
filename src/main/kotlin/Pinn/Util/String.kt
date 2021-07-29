package Pinn.Util

import Pinn.Util.String.isCallPinn
import Pinn.Util.String.isRudely
import java.util.*
import kotlin.String

object String {
    //文本是否匹配给定列表（忽略大小写
    private fun String.isMatchList(list: List<String>): Boolean {
        for (el in list)
            if (this.contains(el.lowercase(Locale.getDefault())))
                return true
        return false
    }

    //是否污秽语言
    fun String.isRudely(): Boolean {
        val list = listOf(
            "cnm", "nm", "nmsl", "sb", "比划", "滚", "爬", "傻逼", "rbq", "操", "你妈", "草", "lbd", "xbzz", "黑手", "艹"
        )
        return this.isMatchList(list)
    }

    //是否呼叫Pinn
    fun String.isCallPinn(): Boolean {
        val list = listOf(
            "小品", "pinn",
        )
        return this.isMatchList(list)
    }

    //字符串是否为纯文本
    fun String.isPureText(): Boolean {
        val list = listOf(
            "[图片]", "[视频]", "{\"app\":", "<?xml", "[表情]",
        )
        return this.isMatchList(list)
    }

    fun String.alike(content: String): Int {
        val msg1 = this
        val msg2 = content

        var head = 0

        for (c1 in if (msg1.length <= msg2.length) msg1 else msg2) {//循环小
            for (c2 in if (msg1.length > msg2.length) msg1 else msg2) {//循环大
                if (c1 == c2) {
                    head++
                }
            }
        }
        //除以最两者最少的字数
        return ((head.toDouble() / if (msg1.length < msg2.length) msg1.length else msg2.length) * 100).toInt()
    }
}