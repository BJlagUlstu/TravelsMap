package com.example.travels_map.presentation.utils.diff_callback

import androidx.recyclerview.widget.DiffUtil
import com.example.travels_map.domain.models.PlaceType

object PlaceTypeDiffCallback : DiffUtil.ItemCallback<PlaceType>() {

    override fun areItemsTheSame(oldItem: PlaceType, newItem: PlaceType): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PlaceType, newItem: PlaceType): Boolean {
        return oldItem == newItem
    }
}