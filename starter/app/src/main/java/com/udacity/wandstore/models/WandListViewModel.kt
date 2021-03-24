package com.udacity.wandstore.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WandListViewModel : ViewModel() {
    companion object {
        private const val TAG = "WandListViewModel"
    }

    private val _wandList = MutableLiveData<MutableList<Wand>>()
    val wandList: LiveData<MutableList<Wand>>
        get() = _wandList

    init {
        Log.i(TAG, "WandListViewModel created!")
        resetList()
    }

    private fun resetList() {
        _wandList.value = ArrayList()
    }

    fun addWand(wand: Wand) {
        _wandList.value?.add(wand)
    }
}