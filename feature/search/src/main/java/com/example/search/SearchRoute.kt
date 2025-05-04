package com.example.search

import androidx.compose.runtime.Composable

@Composable
fun SearchRoute(
    onStartVideoDetail: () -> Unit
) {
    SearchScreen(onStartVideoDetail = onStartVideoDetail)
}