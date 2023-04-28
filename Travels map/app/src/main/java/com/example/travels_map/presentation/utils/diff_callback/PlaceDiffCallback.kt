package com.example.travels_map.presentation.utils.diff_callback

import androidx.recyclerview.widget.DiffUtil
import com.example.travels_map.domain.models.Place

object PlaceDiffCallback : DiffUtil.ItemCallback<Place>() {

    override fun areItemsTheSame(oldItem: Place, newItem: Place): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Place, newItem: Place): Boolean {
        return oldItem == newItem
    }
}