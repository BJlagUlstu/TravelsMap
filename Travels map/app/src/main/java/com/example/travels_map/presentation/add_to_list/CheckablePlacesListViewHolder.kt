package com.example.travels_map.presentation.add_to_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.travels_map.R
import com.example.travels_map.databinding.CheckablePlacesListLayoutBinding
import com.example.travels_map.domain.models.PlaceType

class CheckablePlacesListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding by viewBinding<CheckablePlacesListLayoutBinding>()

    fun bind(placeType: PlaceType, listener: CheckablePlacesListViewListener) {
        with(binding) {
            textViewListName.text = placeType.name
            textViewNumberOfElements.text = "${placeType.count} мест"

            root.setOnClickListener {
                checkbox.isChecked = !checkbox.isChecked

                listener.onLayoutClick(placeType)
            }

            checkbox.setOnClickListener { listener.onCheckboxClick(placeType) }
        }
    }

    companion object {
        fun create(parent: ViewGroup): CheckablePlacesListViewHolder {
            return CheckablePlacesListViewHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.checkable_places_list_layout, parent, false)
            )
        }
    }

    interface CheckablePlacesListViewListener {
        fun onLayoutClick(placeType: PlaceType)
        fun onCheckboxClick(placeType: PlaceType)
    }
}