package com.example.upload.layout

import android.Manifest
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.resource.R as ResourceR
import com.example.ui.component.IGImage
import com.example.ui.component.IGText
import com.example.upload.common.loadImagesFromGallery
import com.example.utils.extension.noRippleClickable
import com.example.utils.extension.showToast
import com.example.utils.log.DebugLog
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@OptIn(ExperimentalPermissionsApi::class)
@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun InstagramGalleryPicker(
    modifier: Modifier = Modifier,
    onImageSelected: (Uri) -> Unit
) {
    val context = LocalContext.current
    val imageUris = remember { mutableStateListOf<Uri>() }
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }

    // 권한 요청 상태
    val permissionState = rememberPermissionState(Manifest.permission.READ_MEDIA_IMAGES)

    // 권한 요청 후 결과에 따른 토스트 메시지
    LaunchedEffect(permissionState.status) {
        if (permissionState.status.isGranted) {
            context.showToast(context.getString(ResourceR.string.toast_permission_granted))
        } else {
            context.showToast(context.getString(ResourceR.string.toast_permission_denied))
        }
    }

    // 이미지 로드
    LaunchedEffect(Unit) {
        val uris = loadImagesFromGallery(context)
        imageUris.clear()
        imageUris.addAll(uris)
        DebugLog("uris : ${uris.toString()}")
        if (uris.isNotEmpty()) selectedImageUri = uris.first()
    }

    Box(modifier = modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            // 선택된 이미지 최대 사이즈로 상단에 표시
            selectedImageUri?.let { uri ->
                IGImage(
                    model = uri,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .padding(16.dp),
                    contentScale = ContentScale.Crop
                )
            }

            // 하단 이미지 그리드
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier.weight(1f)
            ) {
                items(imageUris) { uri ->
                    IGImage(
                        model = uri,
                        contentDescription = null,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .noRippleClickable {
                                selectedImageUri = uri
                            }
                            .padding(1.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }

        // '다음' 버튼을 우상단에 배치
        Button(
            onClick = {
                selectedImageUri?.let { uri ->
                    onImageSelected(uri)
                }
            },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
                .zIndex(1f) // 버튼을 다른 UI 요소보다 위로 올림
        ) {
            IGText(text = stringResource(id = ResourceR.string.action_next))
        }
    }
}
