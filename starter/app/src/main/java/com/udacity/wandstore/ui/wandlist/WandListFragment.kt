package com.udacity.wandstore.ui.wandlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.wandstore.databinding.FragmentWandListBinding
import com.udacity.wandstore.R

/**
 * A simple [Fragment] subclass.
 * Use the [WandListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WandListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentWandListBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_wand_list, container, false)
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(WandListFragmentDirections.actionWandListFragmentToWandDetailFragment())
        }
        return binding.root
    }
}