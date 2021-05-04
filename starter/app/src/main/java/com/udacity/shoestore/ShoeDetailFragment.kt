package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import timber.log.Timber

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding

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
        Timber.i("Do save stuff here")
        val newShoeName = binding.editTextShoeDetailName.text
        val newShoeCompany = binding.editTextShoeDetailCompany.text
        val newShoeSize = binding.editTextShoeDetailSize.text
        val newShoeDescription = binding.editTextShoeDetailDescription.text
        Timber.i("Name: $newShoeName, Company: $newShoeCompany, Size: $newShoeSize, Description: $newShoeDescription")
    }


}