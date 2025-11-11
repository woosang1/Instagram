package com.example.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.toRoute
import com.example.designsystem.theme.LocalColors
import com.example.home.api.HomeDestination
import com.example.mypage.api.MyPageDestination
import com.example.navigation.MainRoute
import com.example.search.api.SearchDestination
import com.example.shorts.api.ShortsDestination
import com.example.ui.component.IGImage
import com.example.upload.api.UploadDestination
import com.example.videodetail.api.VideoDetailDestination

@Composable
fun MainScreen() {
    val mainNavigator = rememberMainNavigator()
    val navController = mainNavigator.navController
    val currentBackStackEntry = navController.currentBackStackEntryAsState().value

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                currentRoute = currentBackStackEntry?.toRoute() ?: HomeDestination,
                onTabSelected = { route ->
                    when (route) {
                        is HomeDestination -> mainNavigator.navigateHome()
                        is SearchDestination -> mainNavigator.navigateSearch()
                        is UploadDestination -> mainNavigator.navigateUpload()
                        is ShortsDestination -> mainNavigator.navigateShorts()
                        is MyPageDestination -> mainNavigator.navigateMyPage()
                        is VideoDetailDestination -> Unit
                    }
                }
            )
        }
    ) { innerPadding ->
        MainNavHost(
            navigator = mainNavigator,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun BottomNavigationBar(
    currentRoute: MainRoute,
    onTabSelected: (MainRoute) -> Unit
) {
    val colors = LocalColors.current
    Surface(
        color = colors.black,
        contentColor = colors.white,
        shadowElevation = 12.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .height(80.dp)
                .padding(horizontal = 20.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            bottomNavItems.forEach { item ->
                val selected = currentRoute == item.route
                BottomNavigationIcon(
                    iconResId = item.iconResId,
                    selected = selected,
                    onClick = { onTabSelected(item.route) },
                    indicatorSize = 40.dp
                )
            }
        }
    }
}

@Composable
private fun BottomNavigationIcon(
    iconResId: Int,
    selected: Boolean,
    onClick: () -> Unit,
    indicatorSize: Dp,
) {
    val colors = LocalColors.current
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = Modifier
            .background(
                color = if (selected) colors.darkGray else colors.black,
                shape = CircleShape
            )
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        IGImage(
            painter = painterResource(id = iconResId),
            contentDescription = null,
            modifier = Modifier.size(30.dp)
        )
    }
}
