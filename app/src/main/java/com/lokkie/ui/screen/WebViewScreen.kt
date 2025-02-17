package com.lokkie.ui.screen

import android.annotation.SuppressLint
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun WebAndNativeView() {
    Column(modifier = Modifier.fillMaxSize()) {
        WebViewScreen(url = "https://daum.net", modifier = Modifier.weight(1f)) // 웹뷰 영역
        NativeAdScreen(modifier = Modifier.fillMaxWidth().height(100.dp)) // 광고 영역
    }
}

@Composable
@SuppressLint("SetJavaScriptEnabled")
fun WebViewScreen(url: String, modifier: Modifier = Modifier) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                settings.domStorageEnabled = true
                settings.cacheMode = android.webkit.WebSettings.LOAD_NO_CACHE
                webViewClient = object : WebViewClient() {
                    override fun shouldOverrideUrlLoading(
                        view: WebView?,
                        request: WebResourceRequest?
                    ): Boolean {
                        return false
                    }
                }
                loadUrl(url)
            }
        }
    )
}