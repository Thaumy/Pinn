package Pinn;

import com.alibaba.fastjson.JSON
import net.mamoe.mirai.Bot
import net.mamoe.mirai.BotFactory
import net.mamoe.mirai.alsoLogin
import net.mamoe.mirai.contact.Contact.Companion.sendImage
import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.*
import net.mamoe.mirai.utils.BotConfiguration
import org.apache.commons.io.FileUtils
import java.io.File


object Util {
    //概率内发生返回true
    fun PR(value: Int): Boolean {
        return (0..100).random() < value
    }

    //千分之一概率
    fun PR1000(value: Int): Boolean {
        return (0..100).random() < value
    }

    //概率行为
    inline fun PR(value: Int, todo: () -> Unit) {
        if ((0..100).random() < value)
            todo()
    }

    //概率行为，并规定失败行为
    inline fun PR(value: Int, todo: () -> Unit, elseTodo: () -> Unit) {
        if ((0..100).random() < value)
            todo()
        else
            elseTodo()
    }

    inline fun Int.random(): Boolean {
        return (0..this).random() == 0
    }

    //是否污秽语言
    fun String.isRudely(): Boolean {
        val rudeList = listOf<String>(
            "cnm", "sb", "比划比划", "滚", "爬", "傻逼", "rbq", "操", "你妈", "草", "nmsl", "nm", "lbd"
        )
        for (el in rudeList)
            if (this.contains(el.toLowerCase()))
                return true
        return false
    }

    //是否呼叫机器人
    fun String.isCallPinn(): Boolean {
        val rudeList = listOf<String>(
            "小品", "pinn"
        )
        for (el in rudeList)
            if (this.contains(el.toLowerCase()))
                return true
        return false
    }
}

