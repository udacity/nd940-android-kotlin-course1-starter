package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel
import timber.log.Timber

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private val viewModel : ShoeViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false)

        binding.cancelButton.setOnClickListener {
            Navigation.findNavController(it).navigateUp()
        }

        binding.saveButton.setOnClickListener{
            onSave()
            Navigation.findNavController(it).navigateUp()
        }

        return binding.root
    }

    private fun onSave() {
        val newShoeName = binding.editTextShoeDetailName.text.toString()
        val newShoeCompany = binding.editTextShoeDetailCompany.text.toString()
        val newShoeSize = binding.editTextShoeDetailSize.text.toString().toDouble()
        val newShoeDescription = binding.editTextShoeDetailDescription.text.toString()
        val newShoe = Shoe(newShoeName, newShoeSize, newShoeCompany, newShoeDescription)
        Timber.i("Name: $newShoeName, Company: $newShoeCompany, Size: $newShoeSize, Description: $newShoeDescription")
        viewModel.addShoe(newShoe)
    }


}