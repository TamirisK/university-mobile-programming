package com.example.mobiletestapp.ui.notifications

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobiletestapp.R
import com.example.mobiletestapp.ui.Notification

class NotificationAdapter(private val notifications: List<Notification>) :
    RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {

    inner class NotificationViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val messageTextView: TextView = view.findViewById(R.id.notificationMessage)
        val timestampTextView: TextView = view.findViewById(R.id.notificationTimestamp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_notification, parent, false)
        return NotificationViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val notification = notifications[position]
        holder.messageTextView.text = notification.message
        holder.timestampTextView.text = formatTimestamp(notification.timestamp)
    }

    override fun getItemCount(): Int = notifications.size

    private fun formatTimestamp(timestamp: Long): String {
        return android.text.format.DateFormat.format("dd/MM/yyyy HH:mm", timestamp).toString()
    }
}