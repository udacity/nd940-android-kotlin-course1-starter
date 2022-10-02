package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.MainViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListingBinding
import com.udacity.shoestore.models.Shoe


class ShoeListingFragment : Fragment() {
    private lateinit var binding: FragmentShoeListingBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoeListingBinding.inflate(inflater)
        binding.floatingActionButton.setOnClickListener {
            onNavigateToShoeDetail()
        }
        setHasOptionsMenu(true)

        val navArgs by navArgs<ShoeListingFragmentArgs>()
        if (navArgs.shoe.isNotEmpty()) {
            viewModel.addShoe(navArgs.shoe)
        }
        viewModel.shoes.observe(viewLifecycleOwner, Observer { shoes ->
            shoes.forEach {
                addNewShoe(it)
            }
        })
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.listing_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        if (item.itemId == R.id.listing_logout) {
            findNavController().popBackStack()
            return true
        }
        return false
    }

    private fun onNavigateToShoeDetail() {
        findNavController().navigate(ShoeListingFragmentDirections.actionShoeListingFragmentToShoeDetailFragment())
    }

    private fun addNewShoe(shoe: String){
        val listLinearLayout: LinearLayout = binding.listLinearLayout

        val newShoe = TextView(context)
        newShoe.text = shoe
        newShoe.setLayoutParams(
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        )

        listLinearLayout.addView(newShoe)
    }
}