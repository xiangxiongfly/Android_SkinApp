package com.example.theme_skin.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.example.theme_skin.theme.ThemeManager
import com.example.theme_skin.theme.ThemeObserver

open class BaseActivity : AppCompatActivity, ThemeObserver {

    constructor() : super()

    constructor(@LayoutRes layoutId: Int) : super(layoutId)

    override fun onCreate(savedInstanceState: Bundle?) {
        ThemeManager.setTheme(this)
        super.onCreate(savedInstanceState)
        ThemeManager.addObserver(this)
    }

    override fun onThemeChanged() {
        ThemeManager.setTheme(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        ThemeManager.removeObserver(this)
    }
}