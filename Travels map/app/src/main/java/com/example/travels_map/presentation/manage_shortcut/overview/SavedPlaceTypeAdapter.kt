package com.example.travels_map.presentation.manage_shortcut.overview

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.travels_map.domain.models.PlaceType
import com.example.travels_map.presentation.utils.diff_callback.PlaceTypeDiffCallback

class SavedPlaceTypeAdapter: ListAdapter<PlaceType, SavedPlaceTypeViewHolder>(PlaceTypeDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedPlaceTypeViewHolder {
        return SavedPlaceTypeViewHolder.create(parent)
    }

    override fun onBindViewHolder(viewHolder: SavedPlaceTypeViewHolder, position: Int) {
        viewHolder.bind(getItem(position))
    }
}