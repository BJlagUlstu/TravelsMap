package com.example.travels_map.presentation.manage_shortcut.reviews

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.travels_map.domain.models.Review
import com.example.travels_map.presentation.utils.diff_callback.ReviewDiffCallback

class ReviewAdapter(
    private val listener: ReviewViewHolder.ReviewViewListener,
) : ListAdapter<Review, ReviewViewHolder>(ReviewDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        return ReviewViewHolder.create(parent)
    }

    override fun onBindViewHolder(viewHolder: ReviewViewHolder, position: Int) {
        viewHolder.bind(getItem(position), listener)
    }
}