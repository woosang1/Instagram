package com.example.upload.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.upload.UploadRoute
import com.example.upload.api.UploadDestination

fun NavController.navigationUpload() {
    navigate(UploadDestination)
}

fun NavGraphBuilder.uploadNavGraph() {
    composable<UploadDestination> {
        UploadRoute()
    }
}