package com.udacity.shoestore.screens.shoes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListingBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodels.ShoeListingViewModel

class ShoeListingFragment : Fragment() {
    private lateinit var binding: FragmentShoeListingBinding

    private val viewModel by activityViewModels<ShoeListingViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_listing, container, false)


        // observe the list
        viewModel.shoeList.observe(viewLifecycleOwner, Observer { shoes ->
            shoes.forEach { shoe: Shoe -> addShoeItem(shoe) }
        }

        )

        binding.addButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeListingFragment_to_shoeDetailEditingFragment)
        )


        // Inflate the layout for this fragment
        return binding.root
    }

    private fun addShoeItem(shoe: Shoe) {
        val newTextView = TextView(context)
        newTextView.text = shoe.name

        binding.shoeList.addView(newTextView)
    }
}