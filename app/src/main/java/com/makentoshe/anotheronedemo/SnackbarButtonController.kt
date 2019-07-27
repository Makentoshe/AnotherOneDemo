package com.makentoshe.anotheronedemo

import android.view.View
import com.google.android.material.snackbar.Snackbar
import java.util.logging.Logger

class SnackbarButtonController(private val logger: Logger) {

    fun exec(view: View) = Snackbar.make(
        view,
        R.string.snackbarNotification,
        Snackbar.LENGTH_INDEFINITE
    ).apply {
        logger.info("Snackbar button was clicked")
        setAction("Got it, dismiss") { dismiss() }
    }.show()
}