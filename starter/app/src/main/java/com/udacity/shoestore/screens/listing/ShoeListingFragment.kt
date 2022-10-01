package com.udacity.shoestore.screens.listing

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListingBinding


class ShoeListingFragment : Fragment() {
    private lateinit var binding: FragmentShoeListingBinding
    private lateinit var viewModel: ShoeListingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoeListingBinding.inflate(inflater)
        binding.floatingActionButton.setOnClickListener {
            onNavigateToShoeDetail()
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.listing_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
        if (item.itemId == R.id.listing_logout) {
            findNavController().popBackStack()
        }
    }

    private fun onNavigateToShoeDetail() {
        findNavController().navigate(ShoeListingFragmentDirections.actionShoeListingFragmentToShoeDetailFragment())
    }

    private fun addNewShoe(){
        val listLinearLayout: LinearLayout = binding.listLinearLayout

        val newShoe = TextView(context)
        newShoe.setLayoutParams(
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        )

        listLinearLayout.addView(newShoe)
    }
}