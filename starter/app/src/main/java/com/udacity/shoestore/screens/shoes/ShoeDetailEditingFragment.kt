package com.udacity.shoestore.screens.shoes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailEditingBinding
import com.udacity.shoestore.databinding.FragmentShoeListingBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.ShoeListingViewModel

class ShoeDetailEditingFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailEditingBinding

    private val viewModel by activityViewModels<ShoeListingViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_detail_editing, container, false)
        binding.shoeDetailSaveButton.setOnClickListener {
            binding.shoe?.let { shoe ->
                viewModel.addNewShoe(shoe)
            }
            findNavController().popBackStack()
        }
        binding.shoeDetailCancelButton.setOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }
}