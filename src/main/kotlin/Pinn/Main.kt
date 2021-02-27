package Pinn

import kotlinx.coroutines.runBlocking


fun main(): Unit = runBlocking {

    BotSender.init()

    ForwardSwitch
    Forward
    Counter
    AdminMsg

    Ohayo

    FixedChat
    SmartChat

    BotSender.Bot.join()//keep alive
}

