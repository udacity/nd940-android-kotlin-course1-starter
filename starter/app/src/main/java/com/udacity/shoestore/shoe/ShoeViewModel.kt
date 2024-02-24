package com.udacity.shoestore.shoe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    // MutableLiveData that will be used to modify the list of shoes
    private val _shoes = MutableLiveData<MutableList<Shoe>>(mutableListOf())

    // Public LiveData for observing the list of shoes from UI components
    val shoes: LiveData<MutableList<Shoe>> = _shoes

    // Function to add a new shoe to the list
    fun addShoe(shoe: Shoe) {
        // create a List of _shoes that use a MutableLiveData
        val list = _shoes.value ?: mutableListOf()
        list.add(shoe)
        _shoes.value = list //notify all active observers
    }

}