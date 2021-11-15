package com.udacity.shoestore.screens.shoeListing;

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

public class ShoeListingViewModel : ViewModel() {
    private val _currentShoes = MutableLiveData<Long>()
    val currentShoes: LiveData<Long>
        get() = _currentShoes
}
