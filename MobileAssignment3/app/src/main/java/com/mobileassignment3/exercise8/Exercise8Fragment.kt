package com.mobileassignment3.exercise8

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.mobileassignment3.R
import com.mobileassignment3.exercise7.User

class Exercise8Fragment : Fragment(R.layout.fragment_exercise8) {

    private val userViewModel: UserViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvUserList: TextView = view.findViewById(R.id.tvUserList)
        val btnAddUser: Button = view.findViewById(R.id.btnAddUser)
        val etUserName: EditText = view.findViewById(R.id.etUserName)

        userViewModel.userList.observe(viewLifecycleOwner) { userList ->
            tvUserList.text = userList.joinToString("\n") { it.name }
        }

        userViewModel.userNameInput.observe(viewLifecycleOwner) { input ->
        }

        btnAddUser.setOnClickListener {
            val userName = etUserName.text.toString().trim()
            if (userName.isNotEmpty()) {
                val newUser = User(id = (userViewModel.userList.value?.size ?: 0) + 1, name = userName)
                userViewModel.addUser(newUser)
                etUserName.text.clear()
            } else {
                etUserName.error = "Please enter a name"
            }
        }

        etUserName.addTextChangedListener {
            userViewModel.updateUserNameInput(it.toString())
        }
    }
}
