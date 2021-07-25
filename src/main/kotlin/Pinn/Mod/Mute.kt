package Pinn.Mod

import Pinn.Core.Bot
import Pinn.Mod.Mute.mute
import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.contact.getMember

object Mute {
    suspend fun Group.mute(id: Long, sec: Int) {
        try {
            this.getMember(id)?.mute(sec)
        } catch (e: Exception) {
        }

    }

    suspend fun Group.unmute(id: Long) {
        try {
            this.getMember(id)?.unmute()
        } catch (e: Exception) {
        }
    }
}