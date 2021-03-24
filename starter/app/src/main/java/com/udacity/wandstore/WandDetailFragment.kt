package com.udacity.wandstore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.wandstore.databinding.FragmentWandDetailBinding
import com.udacity.wandstore.ui.wandlist.WandListFragmentDirections

/**
 * A simple [Fragment] subclass.
 * Use the [WandDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WandDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentWandDetailBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_wand_detail, container, false)

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(WandDetailFragmentDirections.actionWandDetailFragmentToWandListFragment())
        }

        binding.saveButton.setOnClickListener {
            findNavController().navigate(WandDetailFragmentDirections.actionWandDetailFragmentToWandListFragment())
        }
        return binding.root
    }
}