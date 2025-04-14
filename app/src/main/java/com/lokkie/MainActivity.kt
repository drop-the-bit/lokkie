package com.lokkie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.ads.MobileAds
import com.lokkie.ui.screen.AdmobBannerScreen
import com.lokkie.ui.screen.WebViewScreen
import com.lokkie.ui.theme.LokkieTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        MobileAds.initialize(this)
        setContent { LokkieTheme { MainView() } }
    }
}

@Composable
fun MainView() {
    Column(modifier = Modifier.fillMaxSize()) {
        val adUnitId = "ca-app-pub-3940256099942544/6300978111"
        WebViewScreen(
            url = "https://drop-the-bit.github.io/venus/",
            modifier = Modifier
                .weight(1f)
        )
        AdmobBannerScreen(modifier = Modifier.fillMaxWidth(), adUnitId)
    }
}