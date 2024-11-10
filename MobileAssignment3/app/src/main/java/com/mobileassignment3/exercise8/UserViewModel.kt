package com.mobileassignment3.exercise8

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobileassignment3.exercise7.User

class UserViewModel : ViewModel() {

    private val _userList = MutableLiveData<List<User>>()
    val userList: LiveData<List<User>> get() = _userList

    private val _userNameInput = MutableLiveData<String>()
    val userNameInput: LiveData<String> get() = _userNameInput

    init {
        _userList.value = listOf(
            User(1, "Tamiris Abildayeva"),
            User(2, "Tamiris Kang")
        )
    }

    fun addUser(user: User) {
        val updatedList = _userList.value.orEmpty().toMutableList()
        updatedList.add(user)
        _userList.value = updatedList
    }

    fun updateUserNameInput(input: String) {
        _userNameInput.value = input
    }
}