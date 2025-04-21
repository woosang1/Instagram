package com.example.main

import com.example.navigation.MainRoute

data class BottomNavItem(
    val route: MainRoute,
//    val icon: ImageVector,
    val label: String
)

val bottomNavItems = listOf(
    BottomNavItem(MainRoute.Home, "홈"),
    BottomNavItem(MainRoute.Shorts, "Shorts"),
    BottomNavItem(MainRoute.Upload, ""),
    BottomNavItem(MainRoute.Subscribe, "구독"),
    BottomNavItem(MainRoute.MyPage, "내 페이지")
)
