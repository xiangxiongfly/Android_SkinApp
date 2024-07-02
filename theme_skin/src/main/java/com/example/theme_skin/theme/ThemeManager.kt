package com.example.theme_skin.theme

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import com.example.theme_skin.R

object ThemeManager {
    const val THEME_LIGHT = 1
    const val THEME_NIGHT = 2

    fun setTheme(activity: Activity, themeType: Int) {
        val sp = activity.getSharedPreferences("app", AppCompatActivity.MODE_PRIVATE)
        sp.edit()
            .putInt("themeType", themeType)
            .commit()
        setTheme(activity)
        notifyThemeChanged();
    }

    fun setTheme(activity: Activity) {
        val sp = activity.getSharedPreferences("app", AppCompatActivity.MODE_PRIVATE)
        val themeType = sp.getInt("themeType", THEME_LIGHT)
        var themeId = -1
        if (themeType == THEME_LIGHT) {
            themeId = R.style.LightTheme
        } else if (themeType == THEME_NIGHT) {
            themeId = R.style.NightTheme
        }
        activity.setTheme(themeId)
    }

    private val mThemeObservers = mutableListOf<ThemeObserver>()

    fun addObserver(observer: ThemeObserver) {
        mThemeObservers.add(observer)
    }

    fun removeObserver(observer: ThemeObserver) {
        mThemeObservers.remove(observer)
    }

    fun notifyThemeChanged() {
        for (i in mThemeObservers.size - 1 downTo 0) {
            mThemeObservers[i].onThemeChanged()
        }
    }
}