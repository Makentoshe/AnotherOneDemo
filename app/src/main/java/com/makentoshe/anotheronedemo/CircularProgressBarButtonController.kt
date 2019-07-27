package com.makentoshe.anotheronedemo

import android.content.Intent
import android.view.View
import java.util.logging.Logger

class CircularProgressBarButtonController(private val logger: Logger) {

    fun exec(view: View) {
        logger.info("Circular progress bar button was clicked")
        val context = view.context
        context.startActivity(Intent(context, CircularProgressBarActivity::class.java))
    }
}