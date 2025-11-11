package com.example.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.Shape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import coil.compose.AsyncImage
import coil.request.ImageRequest

/**
 * Project-wide image component that centralises image loading logic.
 * Handles both local resources and remote images through Coil.
 */
@Composable
fun IGImage(
    model: Any?,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
    alignment: Alignment = Alignment.Center,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    clipShape: Shape? = null,
    placeholder: Painter? = null,
    error: Painter? = null,
    fallback: Painter? = null,
) {
    val imageModifier = if (clipShape != null) modifier.clip(clipShape) else modifier
    when (model) {
        null -> {
            if (fallback != null) {
                Image(
                    painter = fallback,
                    contentDescription = contentDescription,
                    modifier = imageModifier,
                    alignment = alignment,
                    contentScale = contentScale,
                    alpha = alpha,
                    colorFilter = colorFilter
                )
            } else if (placeholder != null) {
                Image(
                    painter = placeholder,
                    contentDescription = contentDescription,
                    modifier = imageModifier,
                    alignment = alignment,
                    contentScale = contentScale,
                    alpha = alpha,
                    colorFilter = colorFilter
                )
            } else {
                Box(modifier = imageModifier)
            }
        }

        is Painter -> {
            Image(
                painter = model,
                contentDescription = contentDescription,
                modifier = imageModifier,
                alignment = alignment,
                contentScale = contentScale,
                alpha = alpha,
                colorFilter = colorFilter
            )
        }

        is ImageVector -> {
            Image(
                imageVector = model,
                contentDescription = contentDescription,
                modifier = imageModifier,
                alignment = alignment,
                contentScale = contentScale,
                alpha = alpha,
                colorFilter = colorFilter
            )
        }

        is Int -> {
            Image(
                painter = painterResource(id = model),
                contentDescription = contentDescription,
                modifier = imageModifier,
                alignment = alignment,
                contentScale = contentScale,
                alpha = alpha,
                colorFilter = colorFilter
            )
        }

        else -> {
            val context = LocalContext.current
            val imageRequest = remember(model) {
                ImageRequest.Builder(context)
                    .data(model)
                    .crossfade(true)
                    .build()
            }

            AsyncImage(
                modifier = imageModifier,
                model = imageRequest,
                contentDescription = contentDescription,
                contentScale = contentScale,
                alignment = alignment,
                placeholder = placeholder,
                error = error ?: fallback,
                fallback = fallback,
                alpha = alpha,
                colorFilter = colorFilter,
            )
        }
    }
}

/**
 * Overload for explicit painter usage without providing a model.
 */
@Composable
fun IGImage(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
    alignment: Alignment = Alignment.Center,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    clipShape: Shape? = null,
) {
    IGImage(
        model = painter,
        contentDescription = contentDescription,
        modifier = modifier,
        contentScale = contentScale,
        alignment = alignment,
        alpha = alpha,
        colorFilter = colorFilter,
        clipShape = clipShape,
    )
}

