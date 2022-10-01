package com.udacity.shoestore.screens.listing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListingViewModel : ViewModel() {
    private val _shoes = MutableLiveData<List<Shoe>>()
    val shoes : LiveData<List<Shoe>> get() = _shoes
}