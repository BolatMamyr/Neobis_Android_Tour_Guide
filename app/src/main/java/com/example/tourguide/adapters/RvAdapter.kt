package com.example.tourguide.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tourguide.databinding.ItemPlaceBinding
import com.example.tourguide.model.Place

class RvAdapter : RecyclerView.Adapter<RvAdapter.MyViewHolder>() {

    private var placesList = emptyList<Place>()
    var onItemClick: ((Place?) -> Unit)? = null

    inner class MyViewHolder(val binding: ItemPlaceBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(place: Place) {
            binding.place = place
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemPlaceBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = placesList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(placesList[position])

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(placesList[position])
        }

        // increase top margin of first element to 24 (default is 12)
        if (position == 0) {
            holder.binding.cardItemPlace.apply {
                val mLayoutParams = layoutParams
                        as ViewGroup.MarginLayoutParams
                mLayoutParams.topMargin = 48
                layoutParams = mLayoutParams
            }
        }

        // add bottom margin for last element (50dp)
        if (position == placesList.lastIndex) {
            holder.binding.cardItemPlace.apply {
                val mLayoutParams = layoutParams
                        as ViewGroup.MarginLayoutParams
                mLayoutParams.bottomMargin = 100
                layoutParams = mLayoutParams
            }
        }
    }

    fun updateData(newList: List<Place>) {
        placesList = newList
        notifyDataSetChanged()
    }
}