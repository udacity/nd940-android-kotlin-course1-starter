package com.udacity.shoestore.models

import android.util.Log
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel: ViewModel() {

    val shoeList = mutableListOf<Shoe>()

    init {
        Log.i("ShoeViewModel", "ShoeViewModel created!")
        for(i in 1..100){
            shoeList.add(Shoe("My shoe $i", 10.0, "Nike", "Very cool", mutableListOf("")))
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ShoeViewModel", "ShoeViewModel destroyed!")
    }

}