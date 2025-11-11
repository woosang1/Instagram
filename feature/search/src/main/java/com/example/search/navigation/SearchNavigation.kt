package com.example.search.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.search.SearchRoute
import com.example.search.api.SearchDestination

fun NavController.navigationSearch() {
    navigate(SearchDestination)
}

fun NavGraphBuilder.searchNavGraph(
    onStartVideoDetail: () -> Unit
) {
    composable<SearchDestination> {
        SearchRoute(onStartVideoDetail = onStartVideoDetail)
    }
}