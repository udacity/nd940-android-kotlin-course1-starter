package com.udacity.shoestore.shoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment() {

    private var _binding: FragmentShoeDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShoeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]

        binding.viewModel = viewModel

        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.eventShoeAdded.observe(viewLifecycleOwner) { isAdded ->
            if (isAdded) {
                findNavController().popBackStack()
                viewModel.onShoeAddedComplete()
            }
        }

        viewModel.navigateBack.observe(viewLifecycleOwner) { shouldNavigateBack ->
            if (shouldNavigateBack) {
                findNavController().popBackStack()
                viewModel.onNavigationDone()
            }
        }


        binding.saveButton.setOnClickListener {
            viewModel.addShoe()
            //saveShoe()
        }

        binding.cancelButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    /*private fun saveShoe() {


        val name = binding.shoeNameEdit.text.toString()
        val size = binding.shoeSizeEdit.text.toString().toDoubleOrNull() ?: 0.0
        val company = binding.companyEdit.text.toString()
        val description = binding.descriptionEdit.text.toString()

        if (name.isNotBlank() && size > 0 && company.isNotBlank()) {
            val newShoe = Shoe(name, size, company, description)
            viewModel.addShoe(newShoe)
            //findNavController().popBackStack()
        } else {
            // Show error to user, fields are not correctly filled
        }
    }
    */

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
