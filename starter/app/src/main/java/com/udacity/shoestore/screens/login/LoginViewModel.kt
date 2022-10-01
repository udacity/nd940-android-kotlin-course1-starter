package com.udacity.shoestore.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val _email = MutableLiveData<String>()
    val email: LiveData<String>
        get() = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String>
        get() = _password

    private val _hasLogin = MutableLiveData<Boolean>(false)
    val hasLogin: LiveData<Boolean>
        get() = _hasLogin

    fun login() {
        _hasLogin.value = true
    }
}