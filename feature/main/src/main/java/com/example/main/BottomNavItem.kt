package com.example.main

import com.example.navigation.MainRoute
import com.example.resource.R as ResourceR

data class BottomNavItem(
    val route: MainRoute,
    val iconResId: Int,
)

val bottomNavItems = listOf(
    BottomNavItem(MainRoute.Home, ResourceR.drawable.home),
    BottomNavItem(MainRoute.Shorts, ResourceR.drawable.search),
    BottomNavItem(MainRoute.Upload, ResourceR.drawable.plus),
    BottomNavItem(MainRoute.Subscribe, ResourceR.drawable.video),
    BottomNavItem(MainRoute.MyPage, ResourceR.drawable.home)
)