package com.udacity.shoestore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.ShoeViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false
        )

        binding.shoeDetailFragment = this
        binding.viewModel = viewModel

        binding.cancelButton.setOnClickListener {
            Navigation.findNavController(it).navigateUp()
        }

        return binding.root
    }

    fun onSave() {
        if (viewModel.newShoe.name == "") {
            Toast.makeText(
                requireActivity(),
                R.string.blank_shoe_warning_toast,
                Toast.LENGTH_SHORT
            )
                .show()
        } else {
            viewModel.addShoe()
            Navigation.findNavController(requireView()).navigateUp()
        }
    }
}