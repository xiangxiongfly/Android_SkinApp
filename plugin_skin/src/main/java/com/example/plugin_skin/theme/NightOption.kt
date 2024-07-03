package com.example.plugin_skin.theme

import org.alee.component.skin.service.IThemeSkinOption

/**
 * 黑夜模式
 */
internal class NightOption : IThemeSkinOption {

    override fun getStandardSkinPackPath(): LinkedHashSet<String> {
        val set = LinkedHashSet<String>()
        set.add(FileUtils.getNightPath())
        return set
    }
}