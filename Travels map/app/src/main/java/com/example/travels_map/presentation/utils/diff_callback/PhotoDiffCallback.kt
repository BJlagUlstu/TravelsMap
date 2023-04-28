package com.example.travels_map.presentation.utils.diff_callback

import androidx.recyclerview.widget.DiffUtil
import com.example.travels_map.domain.models.Photo

object PhotoDiffCallback : DiffUtil.ItemCallback<Photo>() {

    override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem == newItem
    }
}