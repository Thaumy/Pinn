package Pinn

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

    BotSender.Bot.join()//keep alive
}

