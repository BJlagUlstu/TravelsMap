package com.example.travels_map.presentation.utils.diff_callback

import androidx.recyclerview.widget.DiffUtil
import com.example.travels_map.domain.models.Review

object ReviewDiffCallback : DiffUtil.ItemCallback<Review>() {

    override fun areItemsTheSame(oldItem: Review, newItem: Review): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Review, newItem: Review): Boolean {
        return oldItem == newItem
    }
}