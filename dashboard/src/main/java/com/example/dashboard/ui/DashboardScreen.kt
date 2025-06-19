package com.example.dashboard.ui

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.common.ui.theme.AppTheme
import com.example.dashboard.navigation.DashboardNavHost
import com.example.dashboard.navigation.DashboardRoute

@Composable
fun DashboardScreen(initialTab: String) {

    val navController = rememberNavController()
    val tabs = listOf(DashboardRoute.Home, DashboardRoute.Notifications, DashboardRoute.Settings)
    var selectedTab by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                tabs.forEachIndexed { index, route ->
                    NavigationBarItem(
                        selected = selectedTab == index,
                        onClick = {
                            selectedTab = index
                            navController.navigate(route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        label = { Text(route.replaceFirstChar { it.uppercaseChar() }) },
                        icon = { Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Star icon"
                        ) }
                    )
                }
            }
        }
    ) { innerPadding ->
        DashboardNavHost(
            initialRoute = DashboardRoute.Home,
            navController = navController,
            padding = innerPadding
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    AppTheme {
        DashboardScreen(initialTab = DashboardRoute.Home)
    }
}