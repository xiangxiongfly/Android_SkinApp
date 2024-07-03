package com.example.plugin_skin.base

import android.app.Application
import com.blankj.utilcode.util.ResourceUtils
import com.example.plugin_skin.theme.FileUtils
import com.example.plugin_skin.theme.SkinOptionFactory
import org.alee.component.skin.page.WindowManager
import org.alee.component.skin.service.Config
import org.alee.component.skin.service.ISwitchThemeSkinObserver
import org.alee.component.skin.service.ThemeSkinService

class BaseApp : Application(), ISwitchThemeSkinObserver {

    companion object {
        private lateinit var instance: BaseApp
        fun getInstance(): BaseApp {
            return instance
        }

        init {
            // 换肤模式
            Config.getInstance().setSkinMode(Config.SkinMode.REPLACE_ALL);
            // 性能模式
            Config.getInstance().setPerformanceMode(Config.PerformanceMode.EXPERIENCE_FIRST);
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        copySkinPack()
        ThemeSkinService.getInstance().subscribeSwitchThemeSkin(this);
        WindowManager.getInstance().init(this, SkinOptionFactory())
    }

    private fun copySkinPack() {
        ResourceUtils.copyFileFromAssets(FileUtils.getDayAssetsPath(), FileUtils.getDayPath());
        ResourceUtils.copyFileFromAssets(FileUtils.getNightAssetsPath(), FileUtils.getNightPath());
    }
}