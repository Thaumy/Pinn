package Pinn

import com.alibaba.fastjson.JSON
import kotlinx.coroutines.runBlocking
import net.mamoe.mirai.BotFactory
import net.mamoe.mirai.alsoLogin
import net.mamoe.mirai.utils.BotConfiguration.MiraiProtocol.ANDROID_PHONE
import org.apache.commons.io.FileUtils
import java.io.File

fun main(): Unit = runBlocking {

    BotSender.init()

    ForwardSwitchTrigger
    ForwardTrigger
    FuckTrigger
    MiyabiTrigger
    SleepTrigger
    XiaJbSay
    PinnReply
    Ohayo

    BotSender.Bot.join()
}

