package Pinn.Core

import java.io.File

import com.alibaba.fastjson.JSON
import org.apache.commons.io.FileUtils


object Config {
    private val file = File(".pinn/config.json")
    private val text = FileUtils.readFileToString(file, "UTF-8")
    private val config = JSON.parseObject(text)

    //config nodes
    private val account = JSON.parseObject(config["account"].toString())
    val qqUsr = (account["qid"] as String).toLong()
    val qqPwd = account["pwd"] as String

    private val database = JSON.parseObject(config["database"].toString())
    val dbUsr = database["usr"] as String
    val dbPwd = database["pwd"] as String

    private val groups = JSON.parseObject(config["groups"].toString())
    val melonID = (groups["melon"] as String).toLong()
    val univerID = (groups["univer"] as String).toLong()

    private val admin = config.getJSONArray("admin")
    val adminIDs = run {
        val arr = mutableListOf<Long>()
        for (id in admin)
            arr.add(id.toString().toLong())
        arr
    }
}