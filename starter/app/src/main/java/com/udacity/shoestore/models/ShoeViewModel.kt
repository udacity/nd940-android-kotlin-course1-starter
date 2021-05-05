package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class ShoeViewModel: ViewModel() {

    private val mutableShoeList : MutableList<Shoe> = mutableListOf()
    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
            get() = _shoeList

    init {
        Timber.i("ShoeViewModel created!")
        for(i in 1..40){
            addShoe(Shoe("My shoe $i", 10.0, "Nike", "Very cool", mutableListOf("")))
        }
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("ShoeViewModel destroyed!")
    }

    fun addShoe(shoe : Shoe){
        mutableShoeList.add(shoe)
        _shoeList.value = mutableShoeList
    }
}