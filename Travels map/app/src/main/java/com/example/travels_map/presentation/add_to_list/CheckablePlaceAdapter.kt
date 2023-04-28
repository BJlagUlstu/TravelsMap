package com.example.travels_map.presentation.add_to_list

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.travels_map.domain.models.PlaceType
import com.example.travels_map.presentation.utils.diff_callback.PlaceTypeDiffCallback

class CheckablePlaceAdapter(
    private val listener: CheckablePlacesListViewHolder.CheckablePlacesListViewListener,
) : ListAdapter<PlaceType, CheckablePlacesListViewHolder>(PlaceTypeDiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): CheckablePlacesListViewHolder {
        return CheckablePlacesListViewHolder.create(parent)
    }

    override fun onBindViewHolder(viewHolder: CheckablePlacesListViewHolder, position: Int) {
        viewHolder.bind(getItem(position), listener)
    }
}