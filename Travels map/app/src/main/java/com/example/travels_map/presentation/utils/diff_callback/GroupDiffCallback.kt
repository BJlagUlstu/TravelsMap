package com.example.travels_map.presentation.utils.diff_callback

import androidx.recyclerview.widget.DiffUtil
import com.example.travels_map.domain.models.Group

object GroupDiffCallback : DiffUtil.ItemCallback<Group>() {

    override fun areItemsTheSame(oldItem: Group, newItem: Group): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Group, newItem: Group): Boolean {
        return oldItem == newItem
    }
}