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
import timber.log.Timber


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

        val navArgs by navArgs<ShoeListingFragmentArgs>()
        if (navArgs.shoe != null) {
            viewModel.addShoe(navArgs.shoe!!)
        }
        viewModel.shoes.observe(viewLifecycleOwner, Observer { shoes ->
            shoes.forEach {
                addNewShoe(it)
            }
        })
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.listing_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.listing_logout) {
            findNavController().navigateUp()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun onNavigateToShoeDetail() {
        findNavController().navigate(ShoeListingFragmentDirections.actionShoeListingFragmentToShoeDetailFragment())
    }

    private fun addNewShoe(shoe: Shoe){
        val listLinearLayout: LinearLayout = binding.listLinearLayout

        val newShoe = TextView(context)
        newShoe.text = shoe.name
        newShoe.setLayoutParams(
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        )

        listLinearLayout.addView(newShoe)
    }
}