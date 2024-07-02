package com.example.theme_skin.ui

import android.util.Log
import com.example.theme_skin.R
import com.example.theme_skin.base.BaseActivity
import com.example.theme_skin.theme.ResourceHelper
import kotlinx.android.synthetic.main.activity_second.*

class ThreeActivity : BaseActivity(R.layout.activity_three) {

    override fun onThemeChanged() {
        super.onThemeChanged()
        Log.e("TAG", "ThreeActivity onThemeChanged")
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
