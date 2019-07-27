package com.makentoshe.anotheronedemo

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {

    private val logger = Logger.getLogger(this::class.java.simpleName)

    private val toastButtonController = ToastButtonController(logger)

    private val notificationButtonController = NotificationButtonController(logger)

    private val snackbarButtonController = SnackbarButtonController(logger)

    private val circularProgressBarButtonController = CircularProgressBarButtonController(logger)

    private val toastButton by lazy { findViewById<Button>(R.id.toastButton) }

    private val notificationButton by lazy { findViewById<Button>(R.id.notificationButton) }

    private val snackbarButton by lazy { findViewById<Button>(R.id.snackbarButton) }

    private val circularProgressBarButton by lazy { findViewById<Button>(R.id.circrularProgressBarButton) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logger.info("On Create event was called")

        toastButton.setOnClickListener(toastButtonController::exec)
        notificationButton.setOnClickListener(notificationButtonController::exec)
        snackbarButton.setOnClickListener(snackbarButtonController::exec)
        circularProgressBarButton.setOnClickListener(circularProgressBarButtonController::exec)
    }

}

