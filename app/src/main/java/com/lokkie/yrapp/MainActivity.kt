package com.lokkie.yrapp

import android.os.Bundle
import android.text.TextUtils.replace
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import com.google.android.gms.ads.AdRequest
import com.lokkie.yrapp.databinding.ActivityMainBinding
import com.lokkie.yrapp.ui.theme.YrAppTheme


class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adRequest = AdRequest.Builder()
            .setRequestAgent("android_studio:ad_template")
            .build()
        binding.adView.loadAd(adRequest)

        val myWebView: WebView = binding.root.findViewById(R.id.webview)

        myWebView.settings.run {
            // 웹뷰 자바스크립트 허용
            javaScriptEnabled = true
            javaScriptCanOpenWindowsAutomatically = true
            setSupportMultipleWindows(true)
        }
        myWebView.webViewClient = WebViewClient()
        myWebView.webChromeClient = WebChromeClient()
        myWebView.loadUrl("https://www.google.com")

    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(color = Color.Red) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    YrAppTheme {
        Greeting("test")
    }
}