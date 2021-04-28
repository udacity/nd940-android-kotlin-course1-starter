package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesViewModel: ViewModel() {
    private var _list = MutableLiveData<List<Shoe>>()
    val list: LiveData<List<Shoe>> get() = _list
}