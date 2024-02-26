package com.udacity.shoestore.shoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe

class ShoeFragment : Fragment() {

    // Use activityViewModels to share ViewModel across fragments
    private val viewModel: ShoeViewModel by activityViewModels()
    private var _binding: FragmentShoeListBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShoeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // FAB click listener
        binding.fabAddShoe.setOnClickListener {
            findNavController().navigate(R.id.action_shoeFragment_to_shoeDetailFragment)
        }

        // Observe ViewModel shoes list
        viewModel.shoes.observe(viewLifecycleOwner) { shoes ->
            addShoeViews(shoes)
        }
    }

    private fun addShoeViews(shoes: List<Shoe>) {
        // Clear existing views to avoid duplicates
        binding.shoeListContainer.removeAllViews()

        shoes.forEach { shoe ->
            // Inflate a shoe view using DataBindingUtil if you're using Data Binding in your shoe item layout
            val shoeItemBinding: FragmentShoeBinding = DataBindingUtil.inflate(
                layoutInflater, R.layout.fragment_shoe, binding.shoeListContainer, false)

            // Set shoe data to the binding
            shoeItemBinding.shoe = shoe // Assuming you have a variable 'shoe' in your fragment_shoe.xml

            // Add the bound view to the container
            binding.shoeListContainer.addView(shoeItemBinding.root)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.shoe_list_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout -> {
                findNavController().navigate(R.id.action_global_login_destination)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
