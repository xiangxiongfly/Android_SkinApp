package com.example.theme_skin.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.theme_skin.R
import com.example.theme_skin.base.BaseActivity
import com.example.theme_skin.theme.ResourceHelper
import com.example.theme_skin.theme.ThemeManager
import com.example.theme_skin.theme.ThemeManager.THEME_LIGHT
import com.example.theme_skin.theme.ThemeManager.THEME_NIGHT
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("TAG", "MainActivity onCreate()")
        initViews()
    }

    private fun initViews() {
        btnLight.setOnClickListener {
            ThemeManager.setTheme(this, THEME_LIGHT)
        }
        btnNight.setOnClickListener {
            ThemeManager.setTheme(this, THEME_NIGHT)
        }
        btnToSecond.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }

    /**
     * 更新控件
     */
    override fun onThemeChanged() {
        super.onThemeChanged()
        Log.e("TAG", "MainActivity onThemeChanged")
        val helper = ResourceHelper(this)
        helper.setBackgroundResource(root, R.attr.bgColor)
        helper.setImageResource(bgImage, R.attr.bgImage)
        helper.setImageResource(portrait, R.attr.portrait)
        helper.setImageColorResource(portrait, R.attr.portraitColor)
        helper.setBackgroundResource(portrait, R.attr.portraitBorder)
        helper.setTextResource(description, R.attr.description)
        helper.setTextColorResource(description, R.attr.descriptionColor)
    }
}