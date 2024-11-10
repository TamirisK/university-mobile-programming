package com.mobileassignment3.exercise7

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.mobileassignment3.R

class Exercise7Fragment : Fragment(R.layout.fragment_exercise7) {

    private val userViewModel: UserViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvUserList: TextView = view.findViewById(R.id.tvUserList)
        val btnAddUser: Button = view.findViewById(R.id.btnAddUser)

        userViewModel.userList.observe(viewLifecycleOwner) { userList ->
            tvUserList.text = userList.joinToString("\n") { it.name }
        }

        btnAddUser.setOnClickListener {
            val newUser = User(id = (userViewModel.userList.value?.size ?: 0) + 1, name = "New User")
            userViewModel.addUser(newUser)
        }
    }
}