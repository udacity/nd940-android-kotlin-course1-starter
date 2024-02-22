package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login_destination, container, false)

        view.findViewById<Button>(R.id.login_button).setOnClickListener {
            navigateToWelcomeFragment()
        }

        view.findViewById<Button>(R.id.new_login).setOnClickListener {
            navigateToWelcomeFragment()
        }

        return view
    }

    private fun navigateToWelcomeFragment() {
        activity?.supportFragmentManager?.beginTransaction()?.apply {
            replace(R.id.fragment_container, WelcomeFragment())
            addToBackStack(null) // Optional: Add this transaction to the back stack
            commit()
        }
    }

}
