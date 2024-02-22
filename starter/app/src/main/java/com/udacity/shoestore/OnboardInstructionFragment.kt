package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentOnboardInstructionBinding
import java.lang.String

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