package com.example.mvvmcleanarchitecturetestapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.core.ui.common.routes.AppRoutes
import com.example.feature.presentation.UsersScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoutes.USER_SCREEN.routeName
    ) {
        composable(AppRoutes.USER_SCREEN.routeName) {
            UsersScreen()
        }
    }
}
