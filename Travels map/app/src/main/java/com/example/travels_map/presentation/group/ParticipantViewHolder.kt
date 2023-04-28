package com.example.travels_map.presentation.group

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.travels_map.R
import com.example.travels_map.databinding.UserLayoutBinding
import com.example.travels_map.domain.models.User

class ParticipantViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding by viewBinding<UserLayoutBinding>()

    fun bind(user: User) {
        with(binding) {
            textViewUsername.text = user.login
            textViewName.text = user.name
        }
    }

    companion object {
        fun create(parent: ViewGroup): ParticipantViewHolder {
            return ParticipantViewHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.user_layout, parent, false)
            )
        }
    }
}