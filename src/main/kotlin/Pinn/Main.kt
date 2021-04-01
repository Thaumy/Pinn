package Pinn

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


fun main(): Unit = runBlocking {

    BotSender.init()

    ForwardSwitch
    Forward
    Counter
    AdminMsg

    Ohayo
    Mute

    FixedChat
    //SmartChat


    GlobalScope.run {
        while (true) {
            delay(1000 * 60 * 5)
            if (!BotSender.Bot.isOnline) {
                println("restarting")
                BotSender.init()
            }
            println("online")
        }
    }

    //BotSender.Bot.join()//keep alive
}

