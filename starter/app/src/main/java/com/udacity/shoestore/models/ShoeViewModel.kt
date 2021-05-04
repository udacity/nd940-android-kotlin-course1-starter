package com.udacity.shoestore.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeViewModel: ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
            get() = _shoeList

    init {
        Timber.i("ShoeViewModel created!")
        _shoeList.value = mutableListOf()
        for(i in 1..40){
            _shoeList.value!!.add(Shoe("My shoe $i", 10.0, "Nike", "Very cool", mutableListOf("")))
        }
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("ShoeViewModel destroyed!")
    }

    fun addShoe(shoe : Shoe){
        _shoeList.value!!.add(shoe)
    }

}