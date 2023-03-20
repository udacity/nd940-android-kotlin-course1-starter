package com.udacity.shoestore.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeStoreInventoryViewModel : ViewModel() {
    private val _shoes = MutableLiveData<List<Shoe>?>()
    val shoes: MutableLiveData<List<Shoe>?>
        get() = _shoes

    init {
        // Initialize the list of shoes with some dummy data
        val shoeList = listOf(
            Shoe("Nike Invincible 3", 8.5, "Nike", "With maximum cushioning to support every mile, the Invincible 3 gives you our highest level of comfort underfoot to help you stay on your feet today, tomorrow and beyond. Designed to help keep you on the run, it’s super supportive and bouncy, so that you can propel down your preferred path and come back for your next run feeling ready and reinvigorated."),
            Shoe("Nike Alphafly 2", 7.0, "Nike", "Once you take a few strides in the Nike Alphafly 2, you’ll never look at your favorite pair of old racing shoes the same. These rocket ships are made to help shave precious time off your personal records without surrendering the foundation you need to go the full distance. A thick, lightweight support system brings comfort and speed together so you can enjoy our greatest energy return yet while you chase your personal bests."),
            Shoe("Nike Vaporfly 2", 8.5, "Nike", "Continue the next evolution of speed with racing shoes designed to help you chase new goals and records. The Nike Vaporfly 2 builds on a model loved by racers everywhere with a redesigned upper that aims to improve comfort and breathability. From a 10K to a marathon, this version maintains the responsive cushioning and secure support of the original to help push you toward your personal best.")
        )
        _shoes.value = shoeList
    }

    fun addShoe(shoe: Shoe) {
        val currentShoes = _shoes.value?.toMutableList()
        currentShoes?.add(shoe)
        _shoes.value = currentShoes
    }
}