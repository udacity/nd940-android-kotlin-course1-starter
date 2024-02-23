package com.udacity.shoestore.Welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import timber.log.Timber

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_welcome_destination, container, false)
        val loginButton: Button = view.findViewById(R.id.welcome_button)
        loginButton.setOnClickListener {
            Timber.d("Login button clicked")
            findNavController().navigate(R.id.action_welcome_destination_to_instructionDestination)
        }

        return view
    }


}