package com.udacity.shoestore.screens.shoes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailEditingBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodels.ShoeListingViewModel

class ShoeDetailEditingFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailEditingBinding
    private var shoe:Shoe = Shoe(name = "", company = "", description = "", size = 20.0)

    private val viewModel by activityViewModels<ShoeListingViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)         /// idk why but it has to set true here
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_detail_editing, container, false)

        binding.shoe = shoe

        binding.shoeDetailSaveButton.setOnClickListener {
            binding.shoe?.let { shoe ->
                viewModel.addNewShoe(shoe)
            }
            findNavController().popBackStack()
        }
        binding.shoeDetailCancelButton.setOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.clear()
    }
}