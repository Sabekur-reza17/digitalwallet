package com.sabekur2017.digitalwallet.utilities.extensions

import android.content.res.Configuration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Configuration.toDp(px: Int): Dp {
    val screenWidth = screenWidthDp
    val screenHeight = screenHeightDp
    val scale = when {
        screenWidth >= 600 || screenHeight >= 600 -> 1.5f  // Tablets and large screens
        screenWidth >= 360 -> 1.2f                        // Medium screens
        else -> 1.0f
    }
    return (px * scale).dp
}