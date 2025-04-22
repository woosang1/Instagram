package com.example.navigation

import kotlinx.serialization.Serializable

sealed interface MainRoute {

    @Serializable
    data object Home : MainRoute

    @Serializable
    data object Search : MainRoute

    @Serializable
    data object Upload : MainRoute

    @Serializable
    data object Shorts : MainRoute

    @Serializable
    data object MyPage : MainRoute
}
