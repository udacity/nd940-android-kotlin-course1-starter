package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.ShoeViewModel

class ShoeListFragment : Fragment() {

    private lateinit var viewModel: ShoeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false)


        Log.i("ShoeListFragment", "called ViewModelProvider")
        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)

        binding.shoeViewModel = viewModel
        binding.setLifecycleOwner(this)

        binding.fab.setOnClickListener(Navigation.createNavigateOnClickListener(
            R.id.action_shoeListFragment_to_shoeDetailFragment
        ))

        return binding.root
    }




}