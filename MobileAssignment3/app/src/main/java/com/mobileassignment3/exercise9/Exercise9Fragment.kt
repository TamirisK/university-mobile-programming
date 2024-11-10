package com.mobileassignment3.exercise9

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
//import androidx.fragment.app.activityViewModels
import com.mobileassignment3.R

class Exercise9Fragment : Fragment(R.layout.fragment_exercise9) {

//    private val userViewModel: UserViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvUserList: TextView = view.findViewById(R.id.tvUserList)
        val btnAddUser: Button = view.findViewById(R.id.btnAddUser)
        val btnDeleteAll: Button = view.findViewById(R.id.btnDeleteAll)
        val etUserName: EditText = view.findViewById(R.id.etUserName)

        tvUserList.text = "Sample User Tamiris\nSample User Kang"

        btnAddUser.setOnClickListener {
            val userName = etUserName.text.toString().trim()
            if (userName.isNotEmpty()) {
                tvUserList.text = "User added: $userName"
                etUserName.text.clear()
            } else {
                etUserName.error = "Please enter a name"
            }
        }

        btnDeleteAll.setOnClickListener {
            tvUserList.text = "No Users"
        }
    }
}