package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MainViewModel : ViewModel() {
    private val _shoes = MutableLiveData<List<Shoe>>()
    val shoes: LiveData<List<Shoe>> get() = _shoes

    fun addShoe(newShoe: Shoe) {
        val currentShoeList = _shoes.value
        val newShoeList = mutableListOf<Shoe>()
        newShoeList.addAll(currentShoeList ?: emptyList())
        newShoeList.add(newShoe)
        _shoes.value = newShoeList
    }
}