package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel
import timber.log.Timber

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private val viewModel : ShoeViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false)

        binding.shoeDetailFragment = this
        binding.newShoe = Shoe("", 0.0, "", "")

        binding.cancelButton.setOnClickListener {
            Navigation.findNavController(it).navigateUp()
        }

        return binding.root
    }

    fun onSave() {
        viewModel.addShoe(binding.newShoe ?: Shoe("", 0.0, "", ""))
        Navigation.findNavController(requireView()).navigateUp()
    }
}