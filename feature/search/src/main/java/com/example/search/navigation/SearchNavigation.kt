package com.example.search.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.MainRoute
import com.example.search.SearchRoute

fun NavController.navigationSearch(){
    navigate(MainRoute.Search)
}

fun NavGraphBuilder.searchNavGraph(
    onStartVideoDetail: () -> Unit
) {
    composable<MainRoute.Search>{
        SearchRoute(onStartVideoDetail = onStartVideoDetail)
    }
}