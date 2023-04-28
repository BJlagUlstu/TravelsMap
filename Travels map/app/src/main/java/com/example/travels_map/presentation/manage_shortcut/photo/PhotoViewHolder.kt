package com.example.travels_map.presentation.manage_shortcut.photo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.travels_map.R
import com.example.travels_map.databinding.PhotoLayoutBinding
import com.example.travels_map.domain.models.Photo

class PhotoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding by viewBinding<PhotoLayoutBinding>()

    fun bind(photo: Photo) {
        binding.layout.setImageResource(R.drawable.ic_two_tone_map_128)
    }

    companion object {
        fun create(parent: ViewGroup): PhotoViewHolder {
            return PhotoViewHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.photo_layout, parent, false)
            )
        }
    }
}