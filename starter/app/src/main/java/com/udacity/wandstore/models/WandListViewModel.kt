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

    private val _wandAdded = MutableLiveData<Boolean>()
    val wandAdded: LiveData<Boolean>
    get() = _wandAdded

    init {
        Log.i(TAG, "WandListViewModel created!")
        resetList()
    }

    private fun resetList() {
        _wandList.value = ArrayList()
//        _wandList.value = mutableListOf(
//            Wand("wand 1", 18.0, "Redwood", "Phoenix feather"),
//            Wand("wand 2", 24.0, "Cherry", "Unicorn tail-hair")
//        )
    }

    fun addWand(wand: Wand) {
        _wandList.value?.add(wand)
        _wandAdded.value = true
    }

    fun onDisplayWand() {
        _wandAdded.value = false
    }
}