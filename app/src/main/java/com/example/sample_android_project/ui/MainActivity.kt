package com.example.sample_android_project.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.common.ui.theme.AppTheme
import com.example.dashboard.navigation.DashboardRoute
import com.example.dashboard.ui.DashboardScreen

class MainActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                DashboardScreen(initialTab = DashboardRoute.Home)
            }
        }
    }
}