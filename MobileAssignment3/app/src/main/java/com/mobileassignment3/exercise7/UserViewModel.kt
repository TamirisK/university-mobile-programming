package com.mobileassignment3.exercise7

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    private val _userList = MutableLiveData<List<User>>()
    val userList: LiveData<List<User>> get() = _userList

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
}
