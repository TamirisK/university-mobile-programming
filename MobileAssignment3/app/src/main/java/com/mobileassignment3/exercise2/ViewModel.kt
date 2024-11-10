package com.mobileassignment3.exercise2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _text = MutableLiveData<String>()
    val text: LiveData<String> get() = _text

    fun updateText(newText: String) {
        _text.value = newText
    }
}