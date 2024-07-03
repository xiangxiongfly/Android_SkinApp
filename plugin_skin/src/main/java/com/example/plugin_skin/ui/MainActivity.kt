package com.example.plugin_skin.ui

import android.content.res.AssetManager
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.plugin_skin.R
import com.example.plugin_skin.base.BaseActivity
import com.example.plugin_skin.theme.FileUtils
import com.example.plugin_skin.theme.SkinOptionFactory
import org.alee.component.skin.service.ThemeSkinService
import org.alee.demo.skin.basic.ability.basic.template.IThemeSkinAble
import java.lang.reflect.Method


class MainActivity : BaseActivity(), IThemeSkinAble {

    private val btnDay by lazy { findViewById<Button>(R.id.btnDay) }
    private val btnNight by lazy { findViewById<Button>(R.id.btnNight) }
    private val description by lazy { findViewById<TextView>(R.id.description) }

    private var currentMode: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupTheme(SkinOptionFactory.MODE_DAY)
        Log.e("TAG", "MainActivity onCreate()")

        btnDay.setOnClickListener {
            setupTheme(SkinOptionFactory.MODE_DAY)
        }
        btnNight.setOnClickListener {
            setupTheme(SkinOptionFactory.MODE_NIGHT)
        }
    }

    fun setupTheme(theme: Int) {
        ThemeSkinService.getInstance().switchThemeSkin(theme);
        currentMode = theme
    }

    override fun onThemeSkinSwitchRunOnUiThread() {
        super.onThemeSkinSwitchRunOnUiThread()
        var packageName = ""
        var filePath = ""
        if (currentMode == SkinOptionFactory.MODE_DAY) {
            packageName = "com.example.day"
            filePath = FileUtils.getDayPath()
        } else if (currentMode == SkinOptionFactory.MODE_NIGHT) {
            packageName = "com.example.night"
            filePath = FileUtils.getNightPath()
        }
        val resName = "description"
        val resType = "string"
        try {
            val assetManager = AssetManager::class.java.newInstance()
            val addAssetPath: Method =
                assetManager.javaClass.getMethod("addAssetPath", String::class.java)
            addAssetPath.invoke(assetManager, filePath)
            val resources = Resources(
                assetManager,
                baseContext.resources.displayMetrics,
                baseContext.resources.configuration
            )
            val stringResourceId = resources.getIdentifier(resName, resType, packageName)
            val targetString = resources.getString(stringResourceId)
            Log.e("TAG", "targetString $targetString")
            description.text = targetString
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}