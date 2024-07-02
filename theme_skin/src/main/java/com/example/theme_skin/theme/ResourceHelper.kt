package com.example.theme_skin.theme

import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat

class ResourceHelper(val context: Context) {

    /**
     * 获取当前主题
     */
    fun getTheme(): Resources.Theme {
        return context.theme
    }

    /**
     * 设置背景资源
     */
    fun setBackgroundResource(view: View, attr: Int) {
        val theme: Resources.Theme = getTheme()
        val typedValue = TypedValue()
        if (theme.resolveAttribute(attr, typedValue, true)) {
            val resId = typedValue.resourceId
            view.setBackgroundResource(resId)
        }
    }

    /**
     * 设置图片资源
     */
    fun setImageResource(imageView: ImageView, attr: Int) {
        val theme: Resources.Theme = getTheme()
        val typedValue = TypedValue()
        if (theme.resolveAttribute(attr, typedValue, true)) {
            val resId = typedValue.resourceId
            imageView.setImageResource(resId)
        }
    }

    /**
     * 设置图片颜色
     */
    fun setImageColorResource(imageView: ImageView, attr: Int) {
        val drawable: Drawable? = imageView.drawable
        drawable?.let {
            val tintDrawable = DrawableCompat.wrap(it).mutate()
            val theme: Resources.Theme = getTheme()
            val typedValue = TypedValue()
            if (theme.resolveAttribute(attr, typedValue, true)) {
                val resId = typedValue.resourceId
                val color = ResourcesCompat.getColor(context.resources, resId, theme)
                DrawableCompat.setTint(tintDrawable, color)
                imageView.setImageDrawable(tintDrawable)
            }
        }
    }

    /**
     * 设置文本资源
     */
    fun setTextResource(textView: TextView, attr: Int) {
        val theme: Resources.Theme = getTheme()
        val typedValue = TypedValue()
        if (theme.resolveAttribute(attr, typedValue, true)) {
            val resId = typedValue.resourceId
            textView.setText(resId)
        }
    }

    /**
     * 设置文本颜色资源
     */
    fun setTextColorResource(textView: TextView, attr: Int) {
        val theme: Resources.Theme = getTheme()
        val typedValue = TypedValue()
        if (theme.resolveAttribute(attr, typedValue, true)) {
            val resId = typedValue.resourceId
            val color = ResourcesCompat.getColor(context.resources, resId, theme)
            textView.setTextColor(color)
        }
    }
}