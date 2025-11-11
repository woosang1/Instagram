package com.example.main

import com.example.home.api.HomeDestination
import com.example.mypage.api.MyPageDestination
import com.example.navigation.MainRoute
import com.example.search.api.SearchDestination
import com.example.shorts.api.ShortsDestination
import com.example.upload.api.UploadDestination
import com.example.resource.R as ResourceR

data class BottomNavItem(
    val route: MainRoute,
    val iconResId: Int,
)

val bottomNavItems = listOf(
    BottomNavItem(HomeDestination, ResourceR.drawable.home),
    BottomNavItem(SearchDestination, ResourceR.drawable.search),
    BottomNavItem(UploadDestination, ResourceR.drawable.plus),
    BottomNavItem(ShortsDestination, ResourceR.drawable.video),
    BottomNavItem(MyPageDestination, ResourceR.drawable.home)
)