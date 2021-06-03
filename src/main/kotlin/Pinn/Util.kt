package Pinn;

import java.io.File


object Util {
    //概率行为，并规定失败行为
    inline fun Int.random(todo: () -> Unit, elseTodo: () -> Unit) {
        if (this.random())
            todo()
        else
            elseTodo()
    }

    //概率行为
    inline fun Int.random(todo: () -> Unit) {
        if (this.random())
            todo()
    }

    //取概率结果
    fun Int.random(): Boolean {
        return (1..this).random() == 1
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

    fun img(file: String): File {
        return File(".pinn/img/$file")
    }
}

