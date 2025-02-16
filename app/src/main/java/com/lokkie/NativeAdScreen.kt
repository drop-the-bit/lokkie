package com.lokkie

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun NativeAdScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(Color.Gray)
            .padding(8.dp)
    ) {
        Text(text = "광고 배너 영역", color = Color.White)
    }
}