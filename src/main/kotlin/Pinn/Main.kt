package Pinn

import com.alibaba.fastjson.JSON
import kotlinx.coroutines.runBlocking
import net.mamoe.mirai.BotFactory
import net.mamoe.mirai.alsoLogin
import net.mamoe.mirai.utils.BotConfiguration.MiraiProtocol.ANDROID_PHONE
import org.apache.commons.io.FileUtils
import java.io.File

fun main(): Unit = runBlocking {
    val config = JSON.parseObject(FileUtils.readFileToString(File("config.json"), "UTF-8"))

    val pinn_id = config.getLong("pinn_id")
    val pinn_pwd = config.getString("pinn_pwd")
    val melon_id = config.getLong("melon_id")
    val univer_id = config.getLong("univer_id")

    val Bot = BotFactory.newBot(pinn_id, pinn_pwd) {
        fileBasedDeviceInfo()
        protocol = ANDROID_PHONE
    }.alsoLogin()

    val sender = BotSender(Bot, melon_id, univer_id)

    ForwardSwitchTrigger(sender).open()
    ForwardTrigger(sender).open()
    FuckTrigger(sender).open()
    MiyabiTrigger(sender).open()
    SleepTrigger(sender).open()

    Bot.join()
}

