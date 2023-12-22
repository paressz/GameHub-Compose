package com.farez.gamehub_compose.ui.navigation

import android.app.Application
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.farez.gamehub_compose.AppViewModel
import com.farez.gamehub_compose.ViewModelFactory
import com.farez.gamehub_compose.data.repository.GameRepository
import com.farez.gamehub_compose.ui.screen.detail.DetailScreen
import com.farez.gamehub_compose.ui.screen.gamelist.GameListScreen
import com.farez.gamehub_compose.ui.screen.gamelistfilter.GameListWithFilter
import com.farez.gamehub_compose.ui.screen.inputspek.InputSpekScreen
import com.farez.gamehub_compose.ui.screen.main.MainScreen
import com.farez.gamehub_compose.ui.screen.welcome.WelcomeScreen

@Composable
fun SetupNavigation() {
    var navController = rememberNavController()
    val navigateToDetail : (String) -> Unit = {
        navController.navigate(
            Screen.Detail.createRoute(it)
        )
        Log.d("NAV DATA", "SetupNavigation: $it")
    }
    val appViewModel : AppViewModel = viewModel(
        factory = ViewModelFactory(
            GameRepository.GetInstance(LocalContext.current.applicationContext as Application)
        )
    )
    NavHost(navController = navController, startDestination = Screen.Welcome.route) {
        composable(Screen.Welcome.route) {
            WelcomeScreen(navController)
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("gameName"){type = NavType.StringType})
        ) {
            val gameName = it.arguments?.getString("gameName")
            if (gameName != null) {
                DetailScreen(gameId = gameName)
            }
        }
        composable(Screen.Input.route) {
            InputSpekScreen(navController = navController, appViewModel = appViewModel)
        }
        composable(Screen.Gamelist.route) {
            GameListScreen(appViewModel = appViewModel, navigateToDetail = navigateToDetail)
        }
        composable(Screen.Main.route) {
            MainScreen(navController, appViewModel, navigateToDetail)
        }
        composable(Screen.GamelistWithFilter.route) {
            GameListWithFilter(appViewModel = appViewModel, navigateToDetail = navigateToDetail)
        }
    }
}