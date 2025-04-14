package com.lokkie.webview

import android.app.AlertDialog
import android.content.Context

class JsAlertHandler(private val context: Context) {
    fun show(message: String) {
        AlertDialog.Builder(context)
            .setTitle("js 인터페이스")
            .setMessage(message)
            .setPositiveButton("어 그래", null)
            .show()
    }
}