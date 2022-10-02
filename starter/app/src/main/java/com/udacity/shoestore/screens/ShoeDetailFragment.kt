package com.udacity.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoeDetailBinding.inflate(inflater)

        binding.detailCancelBtn.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.detailSaveBtn.setOnClickListener {
            onNavigateToShoeListing()
        }


        return binding.root
    }

    private fun onNavigateToShoeListing() {
        if (binding.shoeNameEt.text.isNullOrEmpty() ||
            binding.shoeSizeEt.text.isNullOrEmpty() ||
            binding.shoeCompanyEt.text.isNullOrEmpty() ||
            binding.shoeDescriptionEt.text.isNullOrEmpty()) {
            Toast.makeText(context, "Must fill all the fields.", Toast.LENGTH_SHORT).show()
            return
        }

        val newShoe = Shoe(
            binding.shoeNameEt.text.toString(),
            binding.shoeSizeEt.text.toString().toDouble(),
            binding.shoeCompanyEt.text.toString(),
            binding.shoeDescriptionEt.text.toString()
        )
        findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListingFragment(newShoe))
    }
}