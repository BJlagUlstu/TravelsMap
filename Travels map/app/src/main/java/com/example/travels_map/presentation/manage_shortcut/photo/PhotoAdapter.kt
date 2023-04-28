package com.example.travels_map.presentation.manage_shortcut.photo

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.travels_map.domain.models.Photo
import com.example.travels_map.presentation.utils.diff_callback.PhotoDiffCallback

class PhotoAdapter: ListAdapter<Photo, PhotoViewHolder>(PhotoDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder.create(parent)
    }

    override fun onBindViewHolder(viewHolder: PhotoViewHolder, position: Int) {
        viewHolder.bind(getItem(position))
    }
}