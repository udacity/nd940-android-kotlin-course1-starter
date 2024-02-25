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

    // Individual properties for the shoe being added/edited
    val shoeName = MutableLiveData<String?>()
    val shoeSize = MutableLiveData<String?>() // Keeping as String for easier two-way binding
    val shoeCompany = MutableLiveData<String?>()
    val shoeDescription = MutableLiveData<String?>()

    private val _eventShoeAdded = MutableLiveData<Boolean>()
    val eventShoeAdded: LiveData<Boolean>
        get() = _eventShoeAdded

    // Function to add a new shoe to the list
    fun addShoe() {
        val name = shoeName.value ?: ""
        val size = shoeSize.value?.toDoubleOrNull() ?: 0.0
        val company = shoeCompany.value ?: ""
        val description = shoeDescription.value ?: ""

        if (name.isNotBlank() && size > 0 && company.isNotBlank()) {
            val newShoe = Shoe(name, size, company, description)
            val list = _shoes.value ?: mutableListOf()
            list.add(newShoe)
            _shoes.value = list
            _eventShoeAdded.value = true
        } else {
            // Handle validation error
        }

        // Reset fields after adding
        resetShoeFields()
    }

    // Call this method after navigating back to reset the event state
    fun onShoeAddedComplete() {
        _eventShoeAdded.value = false
    }

    private fun resetShoeFields() {
        shoeName.value = null
        shoeSize.value = null
        shoeCompany.value = null
        shoeDescription.value = null
    }

}