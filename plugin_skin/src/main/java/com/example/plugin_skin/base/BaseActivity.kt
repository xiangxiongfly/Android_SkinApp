package com.example.plugin_skin.base

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import org.alee.component.skin.service.ThemeSkinService
import org.alee.demo.skin.basic.ability.basic.template.IThemeSkinAble

open class BaseActivity : AppCompatActivity {

    constructor() : super()

    constructor(@LayoutRes layoutId: Int) : super(layoutId)

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        if (this is IThemeSkinAble) {
            ThemeSkinService.getInstance().subscribeSwitchThemeSkin(this)
        }
    }

    override fun onDetachedFromWindow() {
        if (this is IThemeSkinAble) {
            ThemeSkinService.getInstance().unsubscribeSwitchThemeSkin(this)
        }
        super.onDetachedFromWindow()
    }
}