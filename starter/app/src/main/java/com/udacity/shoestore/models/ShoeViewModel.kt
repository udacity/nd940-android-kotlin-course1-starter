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

    init {
        Timber.i("ShoeViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("ShoeViewModel destroyed!")
    }

    fun addShoe(shoe : Shoe){
        mutableShoeList.add(shoe)
        _shoeListLiveData.value = mutableShoeList
    }
}