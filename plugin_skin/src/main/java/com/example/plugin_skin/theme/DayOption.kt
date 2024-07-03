package com.example.plugin_skin.theme

import org.alee.component.skin.service.IThemeSkinOption

/**
 * 白天模式
 */
internal class DayOption : IThemeSkinOption {

    override fun getStandardSkinPackPath(): LinkedHashSet<String> {
        val set = LinkedHashSet<String>()
        set.add(FileUtils.getDayPath())
        return set
    }
}