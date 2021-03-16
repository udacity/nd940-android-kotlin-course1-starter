package com.udacity.wandstore.ui.wandlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.wandstore.models.Wand
import java.util.*

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
        _wandList.value = mutableListOf(
            Wand("wand 1", 18.0, "Redwood", "Phoenix feather"),
            Wand("wand 2", 24.0, "Cherry", "Unicorn tail-hair")
        )
    }
}