package com.example.sample_android_project

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.common.ui.theme.AppTheme
import com.example.dashboard.di.dashboardModule
import com.example.dashboard.navigation.DashboardRoute
import com.example.dashboard.ui.DashboardScreen
import com.example.sample_android_project.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class SampleAndroidProject: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SampleAndroidProject)
            modules(getProjectModules())
        }
    }

    private fun getProjectModules() = listOf(
        appModule,
        dashboardModule
    )

}