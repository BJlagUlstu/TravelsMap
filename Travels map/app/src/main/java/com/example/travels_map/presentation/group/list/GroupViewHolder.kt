package com.example.travels_map.presentation.group.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.travels_map.R
import com.example.travels_map.databinding.GroupLayoutBinding
import com.example.travels_map.domain.models.Group

class GroupViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding by viewBinding<GroupLayoutBinding>()

    fun bind(group: Group, listener: GroupViewListener) {
        with(binding) {
            layout.text = group.title

            root.setOnClickListener { listener.onLayoutClick(group) }
        }
    }

    companion object {
        fun create(parent: ViewGroup): GroupViewHolder {
            return GroupViewHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.group_layout, parent, false)
            )
        }
    }

    fun interface GroupViewListener {
        fun onLayoutClick(group: Group)
    }
}