package com.makentoshe.anotheronedemo

import android.view.View
import android.widget.Toast
import java.util.logging.Logger

class ToastButtonController(private val logger: Logger) {
    fun exec(view: View) {
        // make log
        logger.info("Toast button was clicked")
        // display toast message
        Toast.makeText(view.context, "Toast", Toast.LENGTH_LONG).show()
    }
}