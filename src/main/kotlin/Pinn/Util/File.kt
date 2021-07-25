package Pinn.Util

import java.io.File
import kotlin.String

object File {
    fun img(file: String): File {
        return File(".pinn/img/$file")
    }
}