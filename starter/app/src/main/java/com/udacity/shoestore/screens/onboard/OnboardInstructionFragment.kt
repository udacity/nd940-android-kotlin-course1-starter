package com.udacity.shoestore.screens.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentOnboardInstructionBinding

class OnboardInstructionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentOnboardInstructionBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_onboard_instruction,
            container,
            false
        )

        binding.nextButton.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_onboardInstructionFragment_to_shoeListingFragment)
        )

        return binding.root
    }
}