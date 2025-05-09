package com.example.upload.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.MainRoute
import com.example.upload.UploadRoute

fun NavController.navigationUpload(){
    navigate(MainRoute.Upload)
}

fun NavGraphBuilder.uploadNavGraph() {
    composable<MainRoute.Upload>{
        UploadRoute()
    }
}