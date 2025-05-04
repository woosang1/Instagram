package com.example.search

import SearchBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.LocalColors
import com.example.search.common.testContentList
import com.example.search.layout.ShortsGridLayout

@Composable
fun SearchScreen(
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LocalColors.current.black)
    ) {
        SearchBar(query = "", onQueryChanged = {})
        ShortsGridLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 8.dp),
            items = testContentList,
            onItemClick = {}
        )
    }
}

