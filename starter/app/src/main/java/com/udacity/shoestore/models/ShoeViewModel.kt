package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class ShoeViewModel: ViewModel() {

    private val mutableShoeList : MutableList<Shoe> = mutableListOf()
    private val _shoeListLiveData = MutableLiveData<List<Shoe>>()
    val shoeListLiveData: LiveData<List<Shoe>>
            get() = _shoeListLiveData

    var newShoe = Shoe("", 0.0, "", "")

    init{
        _shoeListLiveData.value = mutableShoeList
    }

    fun addShoe(){
        mutableShoeList.add(newShoe)
        newShoe = Shoe("", 0.0, "", "")
    }
}