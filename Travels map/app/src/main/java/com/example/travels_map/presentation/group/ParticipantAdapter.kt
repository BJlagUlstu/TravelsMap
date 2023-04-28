package com.example.travels_map.presentation.group

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.travels_map.domain.models.User
import com.example.travels_map.presentation.utils.diff_callback.ParticipantDiffCallback

class ParticipantAdapter : ListAdapter<User, ParticipantViewHolder>(ParticipantDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParticipantViewHolder {
        return ParticipantViewHolder.create(parent)
    }

    override fun onBindViewHolder(viewHolder: ParticipantViewHolder, position: Int) {
        viewHolder.bind(getItem(position))
    }
}