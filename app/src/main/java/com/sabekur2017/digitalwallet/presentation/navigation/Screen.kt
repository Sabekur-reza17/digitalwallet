package com.sabekur2017.digitalwallet.presentation.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object History : Screen("history")
    data object Merchant : Screen("merchant")
    data object Profile : Screen("profile")
    data object Scan : Screen("scan")
}
