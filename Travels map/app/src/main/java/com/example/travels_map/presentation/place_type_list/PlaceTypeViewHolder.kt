package com.example.travels_map.presentation.place_type_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.travels_map.R
import com.example.travels_map.databinding.PlaceTypeLayoutBinding
import com.example.travels_map.domain.models.PlaceType

class PlaceTypeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding by viewBinding<PlaceTypeLayoutBinding>()

    fun bind(placeType: PlaceType, listener: SavedListViewListener) {
        with(binding) {
            textViewListName.text = placeType.name
            textViewNumberOfElements.text = "${placeType.count} мест"

            root.setOnClickListener { listener.onLayoutClick(placeType) }
            moreButton.setOnClickListener { listener.onMoreButtonClick(placeType, it) }
        }
    }

    companion object {
        fun create(parent: ViewGroup): PlaceTypeViewHolder {
            return PlaceTypeViewHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.place_type_layout, parent, false)
            )
        }
    }

    interface SavedListViewListener {
        fun onLayoutClick(placeType: PlaceType)
        fun onMoreButtonClick(placeType: PlaceType, view: View)
    }
}