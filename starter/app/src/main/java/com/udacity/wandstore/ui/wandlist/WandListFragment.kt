package com.udacity.wandstore.ui.wandlist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.wandstore.databinding.FragmentWandListBinding
import com.udacity.wandstore.databinding.FragmentWandListItemBinding
import com.udacity.wandstore.R
import com.udacity.wandstore.models.WandListViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [WandListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WandListFragment : Fragment() {
    private val sharedViewModel: WandListViewModel by activityViewModels()

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

        binding.wandListViewModel = sharedViewModel

        sharedViewModel.wandList.observe(viewLifecycleOwner, Observer { wandList ->
            wandList.forEach { wand ->
                Log.d("WandList", "wand is $wand")
                //inflate item layout
                val itemBinding: FragmentWandListItemBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_wand_list_item, container, false)
                itemBinding.wand = wand
                binding.listLayout.addView(itemBinding.root)
//                wandDetailBinding.wand = wand
//                binding.scrollView2.addView(wandDetailBinding.root)
                //add view
            }
        })

        return binding.root
    }
}