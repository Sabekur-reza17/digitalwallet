package com.sabekur2017.digitalwallet.presentation.components

import com.sabekur2017.digitalwallet.R
import com.sabekur2017.digitalwallet.presentation.navigation.Screen

sealed class BottomNavItem(
    val route: String,
    val titleRes: Int,
    val selectedIconRes: Int,
    val unselectedIconRes: Int
) {
    data object Home : BottomNavItem(
        route = Screen.Home.route,
        titleRes = R.string.home,
        selectedIconRes = R.drawable.ic_home_selected,
        unselectedIconRes = R.drawable.ic_home_unselected
    )
    
    data object Merchant : BottomNavItem(
        route = Screen.Merchant.route,
        titleRes = R.string.merchant,
        selectedIconRes = R.drawable.ic_marcent_icon,
        unselectedIconRes = R.drawable.ic_marcent_icon
    )

    data object History : BottomNavItem(
        route = Screen.History.route,
        titleRes = R.string.history,
        selectedIconRes = R.drawable.ic_history_selected,
        unselectedIconRes = R.drawable.ic_history_unselected
    )

    data object Profile : BottomNavItem(
        route = Screen.Profile.route,
        titleRes = R.string.profile,
        selectedIconRes = R.drawable.ic_profile_selected,
        unselectedIconRes = R.drawable.ic_profile_unselected
    )
}

val bottomNavItems = listOf(
    BottomNavItem.Home,
    BottomNavItem.Merchant,
    null,
    BottomNavItem.History,
    BottomNavItem.Profile
)
