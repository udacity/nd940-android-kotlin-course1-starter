package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MainViewModel : ViewModel() {
    private val _shoes = MutableLiveData<List<String>>()
    val shoes: LiveData<List<String>> get() = _shoes

    fun addShoe(newShoe: String) {
        val currentShoeList = _shoes.value
        val newShoeList = mutableListOf<String>()
        newShoeList.addAll(currentShoeList ?: emptyList())
        newShoeList.add(newShoe)
        _shoes.value = newShoeList
    }
}