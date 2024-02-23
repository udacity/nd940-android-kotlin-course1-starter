package com.udacity.shoestore.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListingViewModel : ViewModel() {
    val shoeList = MutableLiveData<MutableList<Shoe>>(mutableListOf())

    init {
        addShoe(Shoe("Shoe A",20.0,"Adidas", "This is a Adidas Shoe"))
        addShoe(Shoe("Shoe B",25.0,"Nike", "This is a Nike Shoe"))
    }

    fun addNewShoe(shoe: Shoe) {
        // validate before add to list
        if (shoe.name.isNotBlank()) {
            addShoe(shoe)
        }
    }
    private fun addShoe(shoe: Shoe) {
        shoeList.value?.add(shoe)
    }
}