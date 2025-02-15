@file:OptIn(ExperimentalMaterial3Api::class)

package com.lokkie

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.lokkie.ui.theme.LokkieTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LokkieTheme {
                WebViewApp()
//                MyScaffoldScreen()
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
            }

        }
    }
}


@Composable
fun WebViewApp() {
    Column(modifier = Modifier.fillMaxSize()) {
        WebViewScreen(url = "https://daum.net", modifier = Modifier.weight(1f)) // 웹뷰 영역
        NativeAdScreen(modifier = Modifier.fillMaxWidth().height(50.dp)) // 광고 영역
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

@Composable
fun MyScaffoldScreen() {
    Scaffold(
        topBar = { MyTopBar() },  // 상단 바
        floatingActionButton = { MyFloatingButton() }, // FAB 버튼
        bottomBar = { MyBottomBar() } // 하단 바
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding) // 패딩 적용
        ) {
            Text("Hello, Scaffold!", modifier = Modifier.padding(16.dp))
        }
    }
}

@Composable
fun MyTopBar() {
    TopAppBar(
        title = { Text("My App") }
    )
}

@Composable
fun MyFloatingButton() {
    FloatingActionButton(onClick = { /* FAB 클릭 이벤트 */ }) {
        Text("+")
    }
}

@Composable
fun MyBottomBar() {
    BottomAppBar {
        Text("Bottom Bar", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LokkieTheme {
        Greeting("Android")
    }
}