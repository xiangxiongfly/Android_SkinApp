package com.example.plugin_skin.theme

import com.example.plugin_skin.base.BaseApp
import java.io.File

object FileUtils {
    val DAY_NAME = "Day.skin"
    val NIGHT_NAME = "Night.skin"

    /**
     * 根路径
     */
    fun getRootPath(): String =
        BaseApp.getInstance().applicationContext.filesDir.absolutePath

    /**
     * assets路径
     */
    fun getDayAssetsPath() = "day/$DAY_NAME"

    /**
     * assets路径
     */
    fun getNightAssetsPath() = "night/$NIGHT_NAME"

    /**
     * 插件路径
     */
    fun getDayPath(): String {
        val dirFile = File(getRootPath() + File.separator + "SkinPack")
        if (!dirFile.exists()) {
            dirFile.mkdirs()
        }
        return dirFile.absolutePath + File.separator + DAY_NAME
    }

    /**
     * 插件路径
     */
    fun getNightPath(): String {
        val dirFile = File(getRootPath() + File.separator + "SkinPack")
        if (!dirFile.exists()) {
            dirFile.mkdirs()
        }
        return dirFile.absolutePath + File.separator + NIGHT_NAME
    }
}