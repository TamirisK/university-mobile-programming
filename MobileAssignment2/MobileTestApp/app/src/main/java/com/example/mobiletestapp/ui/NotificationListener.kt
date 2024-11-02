package com.example.mobiletestapp
import com.example.mobiletestapp.ui.Notification

interface NotificationListener {
    fun onPostUploaded(notification: Notification)
}