package com.example.mypage.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.mypage.MypageRoute
import com.example.mypage.api.MyPageDestination

fun NavController.navigationMypage() {
    navigate(MyPageDestination)
}

fun NavGraphBuilder.mypageNavGraph() {
    composable<MyPageDestination> {
        MypageRoute()
    }
}