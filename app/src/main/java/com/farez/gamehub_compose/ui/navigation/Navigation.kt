package com.farez.gamehub_compose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.farez.gamehub_compose.ui.screen.gamelist.GameListScreen
import com.farez.gamehub_compose.ui.screen.welcome.WelcomeScreen

@Composable
fun SetupNavigation() {
    var navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Welcome.route) {
        composable(Screen.Welcome.route) {
            WelcomeScreen(navController)
        }
        composable(Screen.Detail.route) {

        }
        composable(Screen.Input.route) {

        }
        composable(Screen.Gamelist.route) {
            GameListScreen()
        }
    }
}