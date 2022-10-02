package com.udacity.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {
    private lateinit var binding: FragmentInstructionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInstructionBinding.inflate(inflater)
        binding.instructionNextBtn.setOnClickListener{
            onNavigateToShoeListing()
        }
        return binding.root
    }

    private fun onNavigateToShoeListing(){
        findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToShoeListingFragment())
    }
}