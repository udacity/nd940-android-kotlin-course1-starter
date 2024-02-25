package com.udacity.shoestore.Instructions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import timber.log.Timber

class InstructionFragment  : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_instruction_destination, container, false)
        val loginButton: Button = view.findViewById(R.id.instruction_button)
        loginButton.setOnClickListener {
            Timber.d("Into button clicked")
            findNavController().navigate(R.id.action_instruction_destination_to_shoeFragment)
        }

        return view
    }


}