package Pinn.Mod

import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.contact.getMember


object Mute {
    suspend fun Group.mute(id: Long, sec: Int):Boolean {
        return try {
            this.getMember(id)?.mute(sec)
            true
        } catch (e: Exception) {
            false
        }
    }

    suspend fun Group.unmute(id: Long):Boolean {
        return try {
            this.getMember(id)?.unmute()
            true
        } catch (e: Exception) {
            false
        }
    }
}