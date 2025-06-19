package com.example.dashboard.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.dashboard.ui.home.HomeScreen
import com.example.dashboard.ui.notifications.NotificationsScreen
import com.example.dashboard.ui.settings.SettingsScreen

@Composable
fun DashboardNavHost(
    initialRoute: String,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    padding: PaddingValues = PaddingValues()
) {
    NavHost(
        startDestination = initialRoute,
        navController = navController,
        modifier = modifier.fillMaxSize()
    ) {
        composable(DashboardRoute.Home) { HomeScreen() }
        composable(DashboardRoute.Notifications) { NotificationsScreen() }
        composable(DashboardRoute.Settings) { SettingsScreen() }
    }
}