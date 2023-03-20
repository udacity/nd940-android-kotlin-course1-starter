package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodels.ShoeStoreInventoryViewModel

class ShoeDetailFragment : Fragment() {
    private val viewModel: ShoeStoreInventoryViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val binding = FragmentShoeDetailBinding.inflate(inflater)

        binding.cancelButton.setOnClickListener { v: View ->
            v.findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        binding.saveButton.setOnClickListener { v: View ->
            val shoeName = binding.shoeNameField.text.toString()
            val shoeCompany = binding.shoeCompanyField.text.toString()
            val shoeSizeInput = binding.shoeSizeField.text.toString()
            val shoeDescription = binding.shoeDescriptionField.text.toString()

            val shoeFieldsNotEmpty = shoeName.isNotEmpty() && shoeCompany.isNotEmpty() && shoeDescription.isNotEmpty()

            if (shoeFieldsNotEmpty) {
                try {
                    val shoeSize = shoeSizeInput.toDouble()
                    viewModel.addShoe(Shoe(shoeName, shoeSize, shoeCompany, shoeDescription))
                    v.findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
                } catch (e: NumberFormatException) {
                    Toast.makeText(requireContext(), "Invalid shoe size!", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(requireContext(), "One or more fields are empty!", Toast.LENGTH_LONG).show()
            }
        }

        return binding.root
    }
}