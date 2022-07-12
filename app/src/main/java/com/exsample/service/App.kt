package com.exsample.service

import android.app.Application
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.annotation.RequiresApi
import com.exsample.service.utils.Objects.CHANNEL_ID

class App: Application() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()
        createNoteficationChannel()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNoteficationChannel() {
        val notificationChannel = NotificationChannel(
            CHANNEL_ID,
            "Example Service Channel",
            NotificationManager.IMPORTANCE_DEFAULT)

        val manager = getSystemService(NotificationManager::class.java)
        manager.createNotificationChannel(notificationChannel)
    }

}