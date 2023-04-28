package com.example.travels_map.presentation.place_type_list.edit_place_list

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.travels_map.domain.models.Place
import com.example.travels_map.presentation.utils.diff_callback.PlaceDiffCallback

class RemovablePlaceAdapter(
    private val listener: RemovablePlaceViewHolder.RemovablePlaceViewListener,
) : ListAdapter<Place, RemovablePlaceViewHolder>(PlaceDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RemovablePlaceViewHolder {
        return RemovablePlaceViewHolder.create(parent)
    }

    override fun onBindViewHolder(viewHolder: RemovablePlaceViewHolder, position: Int) {
        viewHolder.bind(getItem(position), listener)
    }
}