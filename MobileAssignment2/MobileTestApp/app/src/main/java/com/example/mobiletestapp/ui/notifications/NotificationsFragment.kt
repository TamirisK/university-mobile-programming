package com.example.mobiletestapp.ui.notifications

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobiletestapp.R
import com.example.mobiletestapp.ui.Notification

class NotificationsFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var notificationAdapter: NotificationAdapter
    private val notifications = mutableListOf<Notification>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_notifications, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        notificationAdapter = NotificationAdapter(notifications)
        recyclerView.adapter = notificationAdapter

        addInitialNotifications()

        return view
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun addInitialNotifications() {
        notifications.add(Notification("tamiris is online", System.currentTimeMillis()))
        notifications.add(Notification("abildayeva is online", System.currentTimeMillis()))
        notifications.add(Notification("kang is online", System.currentTimeMillis()))

        notificationAdapter.notifyDataSetChanged()
    }

    fun addNotification(notification: Notification) {
        notifications.add(notification)
        notificationAdapter.notifyItemInserted(notifications.size - 1)
        recyclerView.scrollToPosition(notifications.size - 1)
    }
}