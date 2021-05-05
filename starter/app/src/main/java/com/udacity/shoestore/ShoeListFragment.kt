package com.udacity.shoestore

import android.content.Context
import android.os.Bundle
import android.util.TypedValue
import android.view.*
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.ViewGroup.MarginLayoutParams
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
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

        viewModel.shoeListLiveData.observe(viewLifecycleOwner, {
            buildShoeListViews(it)
        })

        return binding.root
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        val item: MenuItem = menu.findItem(R.id.loginFragment)
        item.isVisible = true
    }

    private fun buildShoeListViews(shoeList : List<Shoe>) {
         for (shoe in shoeList){
            //create a CardView for each shoe in viewModel.shoeList
            val shoeCard = CardView(requireContext())
            //set the layoutparams of the CardView
            val layoutParams = MarginLayoutParams(
                    MATCH_PARENT,
                    WRAP_CONTENT,
            )
            //set the margins of the CardView
            val margin = convertDpToPixels(8).toInt()
            layoutParams.setMargins(margin, margin / 2, margin, margin / 2)

            //set the corner radius of the CardView
            val cornerRadius = convertDpToPixels(4)
            shoeCard.radius = cornerRadius
            //apply the layoutParams to the CardView
            shoeCard.layoutParams = layoutParams

             val shoeCardTable = TableLayout(requireContext())
             shoeCardTable.layoutParams = layoutParams

             val shoeCardTableRow = TableRow(requireContext())
             shoeCardTableRow.layoutParams = layoutParams
             val shoeCardTableRow2 = TableRow(requireContext())
             shoeCardTableRow2.layoutParams = layoutParams

            //create a TextView for the shoe name
            val nameText = TextView(requireContext())
            //set the text to the shoe name
            nameText.text = shoe.name
            nameText.textSize = spToPx(50.0f, requireContext())

             //create a TextView for the shoe company
             val companyText = TextView(requireContext())
             //set the text to the shoe name
             companyText.text = shoe.company
             companyText.textSize = spToPx(20.0f, requireContext())

             //create a TextView for the shoe size
             val sizeText = TextView(requireContext())
             //set the text to the shoe name
             sizeText.text = shoe.size.toString()
             sizeText.textSize = spToPx(10.0f, requireContext())

             shoeCardTableRow.addView(nameText)
             shoeCardTableRow2.addView(companyText)
             shoeCardTableRow2.addView(sizeText)
             shoeCardTable.addView(shoeCardTableRow)
             shoeCardTable.addView(shoeCardTableRow2)
             shoeCard.addView(shoeCardTable)
            //add the TextViews to the CardView
            //shoeCard.addView(nameText)
//             shoeCard.addView(companyText)

            //add the CardView to the Linear Layout in the binding.
            binding.shoeListHolder.addView(shoeCard)
        }
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