package com.udacity.shoestore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionBinding

class InstructionsFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentInstructionBinding =
            DataBindingUtil.inflate(
                layoutInflater, R.layout.fragment_instruction, container, false
            )
        binding.shoeListButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                R.id.action_instructionFragment_to_shoeListFragment
            )
        )
        return binding.root
    }
}