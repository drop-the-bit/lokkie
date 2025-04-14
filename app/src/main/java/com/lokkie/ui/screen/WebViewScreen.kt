package com.lokkie.ui.screen

import JsBridge
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
@SuppressLint("SetJavaScriptEnabled")
fun WebViewScreen(url: String, modifier: Modifier = Modifier) {
    AndroidView(
        modifier = modifier, factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                settings.domStorageEnabled = true

                layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT)

                settings.cacheMode = android.webkit.WebSettings.LOAD_NO_CACHE
                webViewClient = object : WebViewClient() {
                    // url 이동 시 브라우저 열지 않도록 설정
                    override fun shouldOverrideUrlLoading(
                        view: WebView?, request: WebResourceRequest?
                    ): Boolean {
                        return false
                    }
                }

                webChromeClient = object : WebChromeClient() {
                    // 브라우저에서 직접 alert가 호출되면 네이티브로 오버라이드
                    override fun onJsAlert(
                        view: WebView?, url: String?, message: String?, result: JsResult?
                    ): Boolean {
                        AlertDialog.Builder(view?.context).setTitle("onJsAlert에서 오버라이드됨!")
                            .setMessage(message)
                            .setPositiveButton("알겠어요") { _, _ -> result?.confirm() }
                            .setOnCancelListener { result?.cancel() }.show()
                        return true
                    }
                }

                // JavaScript 인터페이스 추가
                addJavascriptInterface(JsBridge(context), "Android")

                loadUrl(url)
            }
        })
}