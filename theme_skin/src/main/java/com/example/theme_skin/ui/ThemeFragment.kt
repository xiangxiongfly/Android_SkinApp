package com.example.theme_skin.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.theme_skin.R
import com.example.theme_skin.base.BaseFragment
import com.example.theme_skin.theme.ResourceHelper
import com.example.theme_skin.theme.ThemeManager
import com.example.theme_skin.theme.ThemeManager.THEME_LIGHT
import com.example.theme_skin.theme.ThemeManager.THEME_NIGHT
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_theme.view.*

class ThemeFragment : BaseFragment(R.layout.fragment_theme) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.btnLight.setOnClickListener {
            ThemeManager.setTheme(activity!!, THEME_LIGHT)
        }
        view.btnNight.setOnClickListener {
            ThemeManager.setTheme(activity!!, THEME_NIGHT)
        }
    }

    /**
     * 更新控件
     */
    override fun onThemeChanged() {
        Log.e("TAG", "ThemeFragment onThemeChanged")
        if (isAdded) {
            val helper = ResourceHelper(context!!)
            helper.setBackgroundResource(root, R.attr.bgColor)
            helper.setImageResource(bgImage, R.attr.bgImage)
            helper.setImageResource(portrait, R.attr.portrait)
            helper.setImageColorResource(portrait, R.attr.portraitColor)
            helper.setBackgroundResource(portrait, R.attr.portraitBorder)
            helper.setTextResource(description, R.attr.description)
            helper.setTextColorResource(description, R.attr.descriptionColor)
        }
    }
}