package com.example.travels_map.presentation.place_type_list

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.travels_map.domain.models.PlaceType
import com.example.travels_map.presentation.utils.diff_callback.PlaceTypeDiffCallback

class PlaceTypeAdapter(
    private val listener: PlaceTypeViewHolder.SavedListViewListener,
) : ListAdapter<PlaceType, PlaceTypeViewHolder>(PlaceTypeDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceTypeViewHolder {
        return PlaceTypeViewHolder.create(parent)
    }

    override fun onBindViewHolder(viewHolder: PlaceTypeViewHolder, position: Int) {
        viewHolder.bind(getItem(position), listener)
    }
}