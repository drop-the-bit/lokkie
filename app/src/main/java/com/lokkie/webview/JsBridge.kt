import android.content.Context
import android.webkit.JavascriptInterface
import com.lokkie.webview.JsAlertHandler

// JavaScript 인터페이스 클래스
@Suppress("unused")
class JsBridge(context: Context) {
    private val alertHandler = JsAlertHandler(context)

    @JavascriptInterface
    fun showAlert(message: String) {
        alertHandler.show(message)
    }
}