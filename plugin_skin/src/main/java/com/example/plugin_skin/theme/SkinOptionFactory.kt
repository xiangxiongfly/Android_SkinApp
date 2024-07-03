package com.example.plugin_skin.theme

import android.util.Log
import org.alee.component.skin.service.IOptionFactory
import org.alee.component.skin.service.IThemeSkinOption

class SkinOptionFactory : IOptionFactory {
    companion object {
        // 白天模式
        const val MODE_DAY = 0x1001

        // 黑夜模式
        const val MODE_NIGHT = 0x1002
    }

    override fun defaultTheme() = MODE_DAY

    override fun requireOption(theme: Int): IThemeSkinOption? {
        Log.e("TAG", "requireOption $theme")
        return when (theme) {
            MODE_DAY -> DayOption()
            MODE_NIGHT -> NightOption()
            else -> DayOption()
        }
    }
}