package Pinn.Util

object Random {
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
}