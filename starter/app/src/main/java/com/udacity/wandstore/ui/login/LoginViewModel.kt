package com.udacity.wandstore.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val _isLogged = MutableLiveData<Boolean>()

    init {
        _isLogged.value = false
    }

    fun onLogin() {
        _isLogged.value = true
    }

    fun onLogout() {
        _isLogged.value = false
    }
}