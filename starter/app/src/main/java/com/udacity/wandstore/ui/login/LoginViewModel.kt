package com.udacity.wandstore.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.wandstore.models.Wand

class LoginViewModel : ViewModel() {
    private val _isLogged = MutableLiveData<Boolean>()
    val isLogged: LiveData<Boolean>
    get() = _isLogged

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