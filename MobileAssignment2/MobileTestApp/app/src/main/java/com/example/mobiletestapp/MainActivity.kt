package com.example.mobiletestapp

import android.annotation.SuppressLint
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mobiletestapp.databinding.ActivityMainBinding
import com.example.mobiletestapp.ui.Notification
import com.example.mobiletestapp.ui.notifications.NotificationsFragment

class MainActivity : AppCompatActivity(), NotificationListener {

    private lateinit var binding: ActivityMainBinding
    lateinit var notificationsFragment: NotificationsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_profile, R.id.navigation_addpost, R.id.navigation_dashboard, R.id.navigation_search, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        notificationsFragment = NotificationsFragment()
    }

    override fun onPostUploaded(notification: Notification) {
        notificationsFragment.addNotification(notification)
    }
}