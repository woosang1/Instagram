package com.example.upload.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.MainRoute

fun NavController.navigationUpload(){
    navigate(MainRoute.Upload)
}

fun NavGraphBuilder.UploadNavGraph() {
    composable<MainRoute.Upload>{
        UploadNavGraph()
    }
}