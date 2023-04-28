package com.example.travels_map.presentation.manage_shortcut.overview

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.travels_map.R
import com.example.travels_map.databinding.FragmentOverviewBinding
import com.example.travels_map.domain.models.PlaceType
import com.example.travels_map.presentation.manage_shortcut.TabFragment

class OverviewFragment : TabFragment(R.layout.fragment_overview) {

    override val title: String = "Обзор"

    private val binding by viewBinding(FragmentOverviewBinding::bind)

    private val savedPlaceTypeAdapter = SavedPlaceTypeAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews()
    }

    private fun initializeViews() {
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.placesListRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = savedPlaceTypeAdapter
        }

        preInit()
    }

    private fun preInit() {
        val list = listOf(
            PlaceType(1, "Избранное", 1, listOf()),
            PlaceType(2, "Покупки", 2, listOf()),
            PlaceType(3, "Страшно", 3, listOf()),
        )

        savedPlaceTypeAdapter.submitList(list)
    }

    companion object {
        @JvmStatic
        fun newInstance() = OverviewFragment()
    }
}