package com.example.travels_map.presentation.group.list

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.travels_map.domain.models.Group
import com.example.travels_map.presentation.utils.diff_callback.GroupDiffCallback

class GroupAdapter(
    private val listener: GroupViewHolder.GroupViewListener,
) : ListAdapter<Group, GroupViewHolder>(GroupDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        return GroupViewHolder.create(parent)
    }

    override fun onBindViewHolder(viewHolder: GroupViewHolder, position: Int) {
        viewHolder.bind(getItem(position), listener)
    }
}