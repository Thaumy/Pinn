package Pinn.Core

import java.io.File
import com.alibaba.fastjson.JSON
import org.apache.commons.io.FileUtils

object Config {
    private val configFile = File(".pinn/config.json")
    private val configString = FileUtils.readFileToString(configFile, "UTF-8")
    private val configNode = JSON.parseObject(configString)

    val pinnNode = JSON.parseObject(configNode["pinn"].toString())
    val groupsNode = JSON.parseObject(configNode["groups"].toString())
    val databaseNode = JSON.parseObject(configNode["database"].toString())
}