package com.example.travels_map.presentation.manage_shortcut.reviews

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.travels_map.R
import com.example.travels_map.databinding.FragmentReviewsBinding
import com.example.travels_map.domain.models.Review
import com.example.travels_map.domain.models.User
import com.example.travels_map.presentation.manage_shortcut.TabFragment
import java.util.Date

class ReviewsFragment : TabFragment(R.layout.fragment_reviews) {

    override val title: String = "Отзывы"

    private val binding by viewBinding(FragmentReviewsBinding::bind)

    private val reviewAdapter = ReviewAdapter { }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews()
    }

    private fun initializeViews() {
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.reviewsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = reviewAdapter
        }

        preInit()
    }

    private fun preInit() {
        val list = mutableListOf<Review>()

        for (i in 0..15) {
            list.add(Review(i, "Simple text about place", Date().time, i / 5,
                User(i, "login", "password", "Name $i")))
        }

        reviewAdapter.submitList(list)
    }

    companion object {
        @JvmStatic
        fun newInstance() = ReviewsFragment()
    }
}