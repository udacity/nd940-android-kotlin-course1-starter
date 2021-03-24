package com.udacity.wandstore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.wandstore.databinding.FragmentWandDetailBinding
import com.udacity.wandstore.models.Wand
import com.udacity.wandstore.models.WandListViewModel

class WandDetailFragment : Fragment() {
    private val sharedViewModel: WandListViewModel by activityViewModels()
    private lateinit var wand: Wand

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentWandDetailBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_wand_detail, container, false)

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(WandDetailFragmentDirections.actionWandDetailFragmentToWandListFragment())
        }

        binding.wandListViewModel = sharedViewModel
        binding.lifecycleOwner = this

        binding.saveButton.setOnClickListener {
            wand = Wand(binding.nameEntry.text.toString(), binding.sizeEntry.text.toString().toDouble(), binding.woodEntry.text.toString(), binding.coreEntry.text.toString())
            sharedViewModel.addWand(wand)
            findNavController().navigate(WandDetailFragmentDirections.actionWandDetailFragmentToWandListFragment())
        }
        return binding.root
    }
}