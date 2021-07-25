package Pinn.Mod

import Pinn.Core.Bot
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

object ReLogin {
    init {
        runBlocking {
            while (true) {
                delay(1000 /** 60 * 5*/)
                if (!Bot.Instance.isOnline) {
                    println("offline:restarting")
                    Bot.login()
                }
                println("online:heartbeat")
            }
        }
    }
}