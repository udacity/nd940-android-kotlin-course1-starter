package com.udacity.shoestore.screens.instruction

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {

    private lateinit var binding: FragmentInstructionBinding
    private lateinit var viewModel: InstructionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInstructionBinding.inflate(inflater)
        binding.button2.setOnClickListener{
            onNavigateToShoeListing()
        }
        return binding.root
    }

    private fun onNavigateToShoeListing(){
        findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToShoeListingFragment())
    }
}