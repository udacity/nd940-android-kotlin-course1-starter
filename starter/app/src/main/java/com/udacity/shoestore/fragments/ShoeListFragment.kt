package com.udacity.shoestore.fragments

import android.content.Context
import android.os.Bundle
import android.util.TypedValue
import android.view.*
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.ViewGroup.MarginLayoutParams
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel


class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false
        )

        binding.fab.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                R.id.action_shoeListFragment_to_shoeDetailFragment
            )
        )

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

    //create the complete views necessary to display one shoe item and add them to the
    //shoe list container in the binding
    private fun buildShoeListViews(shoeList: List<Shoe>) {
        //for every shoe in the viewModel shoeList LiveData
        for (shoe in shoeList) {
            //create card view
            val shoeCard = createShoeCardView()
            //create linear layout for inside shoeCard
            val linearLayout = createLinearLayoutForShoeCard()
            //add the necessary text views to the linear layout
            buildTextViewsInLinearLayout(linearLayout, shoe)
            //add the LinearLayout to the CardView
            shoeCard.addView(linearLayout)
            //add the CardView to the LinearLayout CardView container in the binding.
            binding.shoeListHolder.addView(shoeCard)
        }
    }

    //add the necessary TextViews to a given LinearLayout for a particular shoe item
    private fun buildTextViewsInLinearLayout(shoeCardLinearLayout: LinearLayout, shoe: Shoe) {
        val companyTextView = createShoeTextView(shoe.company, Gravity.END, 20.0f)
        val nameTextView = createShoeTextView(shoe.name, Gravity.START, 30.0f)
        val descriptionTextView = createShoeTextView(shoe.description, Gravity.START, 15.0f)
        val sizeTextView = createShoeTextView(
            getString(
                R.string.format_shoe_list_fragment_shoe_size,
                (if (shoe.size == 0.0) {
                    "--.-"
                } else {
                    shoe.size.toString()
                })
            ),
            Gravity.END,
            15.0f
        )

        shoeCardLinearLayout.addView(companyTextView)
        shoeCardLinearLayout.addView(nameTextView)
        shoeCardLinearLayout.addView(descriptionTextView)
        shoeCardLinearLayout.addView(sizeTextView)
    }

    //create and return a single empty card view set up for displaying one shoe item on the list
    private fun createShoeCardView(): CardView {
        val layoutParams = MarginLayoutParams(
            MATCH_PARENT,
            WRAP_CONTENT,
        )
        //create a CardView
        val shoeCard = CardView(requireContext())

        //set the margins of the CardView
        val margin = convertDpToPixels(8).toInt()
        layoutParams.setMargins(margin, margin / 2, margin, margin / 2)

        //set the corner radius of the CardView
        shoeCard.radius = convertDpToPixels(4)
        val paddingAmount = convertDpToPixels(8).toInt()
        shoeCard.setContentPadding(paddingAmount, paddingAmount, paddingAmount, paddingAmount)

        //apply the layoutParams to the CardView
        shoeCard.layoutParams = layoutParams

        return shoeCard
    }

    //create and return the LinearLayout that goes inside a shoe item's CardView in the list
    private fun createLinearLayoutForShoeCard(): LinearLayout {
        val layoutParams = MarginLayoutParams(
            MATCH_PARENT,
            WRAP_CONTENT,
        )
        val shoeCardLinearLayout = LinearLayout(requireContext())
        shoeCardLinearLayout.orientation = LinearLayout.VERTICAL
        shoeCardLinearLayout.layoutParams = layoutParams
        return shoeCardLinearLayout
    }

    //create and return a TextView with the given text, gravity and text size
    private fun createShoeTextView(text: String, gravity: Int, textSizeSP: Float): TextView {
        val textView = TextView(requireContext())
        textView.text = text
        textView.gravity = gravity
        textView.textSize = spToPx(textSizeSP, requireContext())
        return textView
    }

    //convert DP values to pixel values which scale with the display's pixel density
    private fun convertDpToPixels(dp: Int): Float {
        //Roman Mazur - https://stackoverflow.com/questions/4914039/margins-of-a-linearlayout-programmatically-with-dp
        val d = requireContext().resources.displayMetrics.density
        return (dp * d) // margin in pixels
    }

    //convert SP values to pixel values which scale with the display's pixel density
    private fun spToPx(sp: Float, context: Context): Float {
        //AndroidEx - https://stackoverflow.com/questions/29664993/how-to-convert-dp-px-sp-among-each-other-especially-dp-and-sp
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_PX,
            sp,
            context.resources.displayMetrics
        )
    }

}