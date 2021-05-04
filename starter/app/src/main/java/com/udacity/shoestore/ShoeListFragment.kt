package com.udacity.shoestore

import android.content.Context
import android.os.Bundle
import android.util.TypedValue
import android.view.*
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.ViewGroup.MarginLayoutParams
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.ShoeViewModel
import timber.log.Timber


class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private val viewModel : ShoeViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_shoe_list, container, false)

        binding.fab.setOnClickListener(Navigation.createNavigateOnClickListener(
                R.id.action_shoeListFragment_to_shoeDetailFragment
        ))

        buildShoeListViews()

        return binding.root
    }

    private fun buildShoeListViews(){
        for (shoe in viewModel.shoeList.value!!){
            //create a CardView for each shoe in viewModel.shoeList
            val shoeCard = CardView(requireContext())
            //set the layoutparams of the CardView
            val layoutParams = MarginLayoutParams(
                    MATCH_PARENT,
                    WRAP_CONTENT,
            )
            //set the margins of the CardView
            val margin = convertDpToPixels(8).toInt()
            layoutParams.setMargins(margin, margin, margin, 0)
            //add a bottom margin to the last card
            if(viewModel.shoeList.value!!.indexOf(shoe) == viewModel.shoeList.value!!.size - 1){
                layoutParams.bottomMargin = margin
            }
            //set the corner radius of the CardView
            val cornerRadius = convertDpToPixels(4)
            shoeCard.radius = cornerRadius
            //apply the layoutParams to the CardView
            shoeCard.layoutParams = layoutParams

            //create a TextView for the shoe name
            val nameText = TextView(requireContext())
            //set the text to the shoe name
            nameText.text = shoe.name
            nameText.textSize = spToPx(50.0f, requireContext())

            //add the TextView to the CardView
            shoeCard.addView(nameText)

            //add the CardView to the Linear Layout in the binding.
            binding.shoeListHolder.addView(shoeCard)
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        val item: MenuItem = menu.findItem(R.id.loginFragment)
        item.isVisible = true
    }

    private fun convertDpToPixels(dp: Int) : Float {
        //Roman Mazur - https://stackoverflow.com/questions/4914039/margins-of-a-linearlayout-programmatically-with-dp
        val d = requireContext().resources.displayMetrics.density
        return (dp * d) // margin in pixels
    }


    private fun spToPx(sp: Float, context: Context): Float {
        //AndroidEx - https://stackoverflow.com/questions/29664993/how-to-convert-dp-px-sp-among-each-other-especially-dp-and-sp
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, sp, context.resources.displayMetrics)
    }


}