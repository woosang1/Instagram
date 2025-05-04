package com.example.upload

import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.designsystem.theme.LocalColors
import com.example.upload.layout.InstagramGalleryPicker
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.utils.extension.showToast

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun UploadScreen(
) {
    val context = LocalContext.current
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }

    val onImageSelected: (Uri) -> Unit = { uri ->
        selectedImageUri = uri
        context.showToast("사진 선택")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LocalColors.current.black)
    ) {
        if(selectedImageUri == null){
            InstagramGalleryPicker(
                modifier = Modifier,
                onImageSelected = onImageSelected
            )
        }
        else {
            Spacer(modifier = Modifier.height(16.dp))
            selectedImageUri?.let { uri ->
                AsyncImage(
                    model = uri,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .padding(16.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}