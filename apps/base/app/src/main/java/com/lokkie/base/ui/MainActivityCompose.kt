package com.lokkie.base.ui

import android.annotation.SuppressLint
import android.webkit.WebView
import android.content.Context
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

import android.webkit.WebResourceRequest

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun MainActivityCompose() {
    Column(modifier = Modifier.fillMaxSize()) {
        // Handle redirects within the WebView
        AndroidView(
            factory = { context ->
                WebView(context).apply {
                    settings.javaScriptEnabled = true
                    webViewClient = object : WebViewClient() {
                        override fun shouldOverrideUrlLoading(
                            view: WebView?,
                            request: WebResourceRequest?
                        ): Boolean {
                            view?.loadUrl(request?.url.toString())
                            return true
                        }
                    }
                    loadUrl("https://www.google.com/")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f, fill = true)
        )

        AndroidView(
            factory = { context -> createAdView(context) },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        )
    }
}

private fun createAdView(context: Context): AdView {
    return AdView(context).apply {
        setAdSize(AdSize.BANNER) // 표준 배너 광고 크기
        adUnitId = "ca-app-pub-3940256099942544/6300978111" // 테스트 광고 ID
        loadAd(AdRequest.Builder().build())
    }
}