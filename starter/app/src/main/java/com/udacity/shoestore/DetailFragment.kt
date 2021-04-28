package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentDetailBinding>(
            inflater, R.layout.fragment_detail, container, false
        )

        binding.cancelButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_detailFragment_to_listingFragment)
        )

        binding.saveButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_detailFragment_to_listingFragment)
        )

        return binding.root
    }
}