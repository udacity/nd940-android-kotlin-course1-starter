package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel: ViewModel() {

    val shoeList = mutableListOf<Shoe>()

    init {
        Log.i("ShoeViewModel", "ShoeViewModel created!")
        shoeList.add(Shoe("My first shoe", 10.0, "Nike", "Very cool", mutableListOf("")))
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ShoeViewModel", "ShoeViewModel destroyed!")
    }

}