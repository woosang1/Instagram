package com.example.mypage.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.mypage.MypageRoute
import com.example.navigation.MainRoute

fun NavController.navigationMypage(){
    navigate(MainRoute.MyPage)
}

fun NavGraphBuilder.mypageNavGraph() {
    composable<MainRoute.MyPage>{
        MypageRoute()
    }
}