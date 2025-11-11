package com.example.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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
    NavigationBar(
        modifier = Modifier.height(56.dp),
        containerColor = LocalColors.current.black,
        contentColor = LocalColors.current.white
    ) {
        bottomNavItems.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = { onTabSelected(item.route) },
                icon = {
                    IGImage(
                        painter = painterResource(id = item.iconResId),
                        contentDescription = "",
                        modifier = Modifier.fillMaxSize().padding(4.dp)
                    )
                }
            )
        }
    }
}
