package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.viewmodels.ShoeStoreInventoryViewModel

class ShoeListFragment : Fragment() {
    private val viewModel: ShoeStoreInventoryViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val binding = FragmentShoeListBinding.inflate(inflater)

        removeBackArrow()

        setupMenu()

        binding.addShoeButton.setOnClickListener { v: View ->
            v.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }

        viewModel.shoes.observe(viewLifecycleOwner) { shoes ->
            binding.shoeList.removeAllViews()

            if (shoes != null) {
                for (shoe in shoes) {
                    val textView = TextView(context)
                    textView.text = getString(R.string.shoe_item, shoe.name, shoe.company, shoe.size, shoe.description)
                    binding.shoeList.addView(textView)
                }
            }
        }

        return binding.root
    }

    private fun removeBackArrow() {

    }

    private fun setupMenu() {
        (requireActivity() as MenuHost).addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_shoe_list, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                // Validate and handle the selected menu item
                when(menuItem.itemId) {
                    R.id.logout ->
                        findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
                }
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }
}