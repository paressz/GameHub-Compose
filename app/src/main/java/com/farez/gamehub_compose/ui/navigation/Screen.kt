package com.farez.gamehub_compose.ui.navigation

sealed class Screen(val route: String) {
    object Input : Screen(ScreenName.INPUT.name)
    object Welcome : Screen(ScreenName.WELCOME.name)
    object Gamelist : Screen(ScreenName.GAMELIST.name)
    object Detail : Screen(ScreenName.DETAIL.name)
}

enum class ScreenName {
    INPUT,
    WELCOME,
    GAMELIST,
    DETAIL
}