package com.makentoshe.anotheronedemo

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.view.View
import androidx.core.app.NotificationCompat
import java.util.logging.Logger
import kotlin.random.Random

class NotificationButtonController(private val logger: Logger) {

    /** Returns an application title */
    private fun getChannelId(context: Context): String {
        return context.applicationInfo.loadLabel(context.packageManager).toString()
    }

    /** Returns a notification manager */
    private fun getNotificationManager(context: Context): NotificationManager {
        return context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    /** Returns a notification builder for a specific android version */
    private fun getBuilder(context: Context): NotificationCompat.Builder {
        val channelId = getChannelId(context)
        val notificationManager = getNotificationManager(context)

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                channelId,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
            NotificationCompat.Builder(context, channelId).setChannelId(channelId)
        } else {
            NotificationCompat.Builder(context, channelId)
        }
    }

    private fun NotificationCompat.Builder.createNotification(title: String, content: String): Notification {
        return setContentTitle(title).setContentText(content).setSmallIcon(R.drawable.ic_launcher_foreground).build()
    }

    fun exec(view: View) {
        val context = view.context
        // create log
        logger.info("Notification button was clicked")
        //create notification instance
        val notification = getBuilder(context).createNotification("Notification Title", "Notification Text")
        // DO NOT USE Random.nextInt() for notifications in real projects
        getNotificationManager(context).notify(Random.nextInt(), notification)
        // create another log
        logger.info("Notification was displayed")
    }
}