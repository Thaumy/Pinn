package Pinn.Util

import Pinn.Util.Random.random

object Random {
    //分之一概率行为，并规定失败行为
    inline fun Int.random(todo: () -> Unit, elseTodo: () -> Unit) {
        if (this.random())
            todo()
        else
            elseTodo()
    }

    //分之一概率行为
    inline fun Int.random(todo: () -> Unit) {
        if (this.random())
            todo()
    }

    //百分比概率行为，最高精度百万分之一
    inline fun rand(rate: Double, todo: () -> Unit) {
        if ((1..1000000).random() <= rate * 1000000)
            todo()
    }

    //取概率结果
    fun Int.random(): Boolean {
        return (1..this).random() == 1
    }
}