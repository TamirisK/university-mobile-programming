package com.mobileassignment3.exercise9

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.mobileassignment3.exercise9.User
import com.mobileassignment3.exercise9.UserDatabase
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val userDao: UserDao = UserDatabase.getDatabase(application).userDao()
    val allUsers: LiveData<List<User>> = userDao.getAllUsers()

    fun insert(user: User) {
        viewModelScope.launch {
            userDao.insert(user)
        }
    }

    fun deleteAll() {
        viewModelScope.launch {
            userDao.deleteAll()
        }
    }
}
