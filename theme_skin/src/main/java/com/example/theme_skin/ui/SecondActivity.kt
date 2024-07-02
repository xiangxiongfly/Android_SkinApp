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
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initViews()
    }

    private fun initViews() {
        btnLight.setOnClickListener {
            ThemeManager.setTheme(this, THEME_LIGHT)
        }
        btnNight.setOnClickListener {
            ThemeManager.setTheme(this, THEME_NIGHT)
        }
        btnToThree.setOnClickListener {
            startActivity(Intent(this, ThreeActivity::class.java))
        }
    }

    override fun onThemeChanged() {
        super.onThemeChanged()
        Log.e("TAG","SecondActivity onThemeChanged")
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
