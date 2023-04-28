package com.example.travels_map.presentation.manage_shortcut.reviews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.travels_map.R
import com.example.travels_map.databinding.ReviewLayoutBinding
import com.example.travels_map.domain.models.Review

class ReviewViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding by viewBinding<ReviewLayoutBinding>()

    fun bind(review: Review, listener: ReviewViewListener) {
        with(binding) {
            textViewUser.text = review.user.name
            textViewRating.text = review.rating.toString()
            textViewDate.text = review.date.toString()
            textViewReviewText.text = review.text

            moreButton.setOnClickListener { listener.onMoreButtonClick(review) }
        }
    }

    companion object {
        fun create(parent: ViewGroup): ReviewViewHolder {
            return ReviewViewHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.review_layout, parent, false)
            )
        }
    }

    fun interface ReviewViewListener {
        fun onMoreButtonClick(review: Review)
    }
}