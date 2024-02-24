package com.udacity.shoestore.shoe

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

import com.udacity.shoestore.placeholder.PlaceholderContent.PlaceholderItem
import com.udacity.shoestore.databinding.FragmentShoeBinding
import com.udacity.shoestore.models.Shoe

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyShoeRecyclerViewAdapter(
    private val shoes: MutableList<Shoe>
) : RecyclerView.Adapter<MyShoeRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentShoeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shoe = shoes[position]
        holder.shoeNameView.text = shoe.name
        holder.shoeSizeView.text = "Size: ${shoe.size}"
    }
    override fun getItemCount(): Int = shoes.size
    fun updateShoes(updatedShoes: List<Shoe>) {
        shoes.clear() // Clear existing data
        shoes.addAll(updatedShoes) // Add new data
        notifyDataSetChanged() // Notify the adapter to refresh the view
    }

    inner class ViewHolder(binding: FragmentShoeBinding) : RecyclerView.ViewHolder(binding.root) {
        val shoeNameView: TextView = binding.shoeName
        val shoeSizeView: TextView = binding.shoeSize
    }

}