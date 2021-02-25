package Pinn

import kotlinx.coroutines.runBlocking


fun main(): Unit = runBlocking {

    BotSender.init()

    ForwardSwitch
    Forward
    Counter
    AdminMsg

    Miyabi

    RandomReply
    PinnReply
    Ohayo

    BotSender.Bot.join()//bot保活
}

