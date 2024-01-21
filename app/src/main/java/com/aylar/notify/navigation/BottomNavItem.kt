package com.aylar.notify.navigation

import androidx.annotation.DrawableRes

data class BottomNavItem(
    val name: String,
    val route: String,
    @DrawableRes val icon: Int,
)
