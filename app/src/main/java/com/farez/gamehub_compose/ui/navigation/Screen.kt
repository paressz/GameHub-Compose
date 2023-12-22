package com.farez.gamehub_compose.ui.navigation

sealed class Screen(val route: String) {
    data object Input : Screen(ScreenName.INPUT.name)
    data object Welcome : Screen(ScreenName.WELCOME.name)
    data object Gamelist : Screen(ScreenName.GAMELIST.name)
    data object GamelistWithFilter : Screen(ScreenName.GAMELISTWITHFILTER.name)
    data object Detail : Screen(ScreenName.DETAIL.name + "/{gameName}") {
        fun createRoute(gameName : String) = ScreenName.DETAIL.name + "/$gameName"
    }
    data object Main : Screen(ScreenName.MAIN.name)
}

enum class ScreenName {
    INPUT,
    WELCOME,
    GAMELIST,
    GAMELISTWITHFILTER,
    DETAIL,
    MAIN
}