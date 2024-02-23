package com.udacity.shoestore.Login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import timber.log.Timber

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login_destination, container, false)

        val loginButton: Button = view.findViewById(R.id.login_button)
        loginButton.setOnClickListener {
            Timber.d("Login button clicked")
            findNavController().navigate(R.id.action_login_destination_to_welcome_destination)
        }

        val newUserButton: Button = view.findViewById(R.id.new_login)
        newUserButton.setOnClickListener {
            Timber.d("New user button clicked")
            findNavController().navigate(R.id.action_login_destination_to_welcome_destination)
        }

        return view
    }

}