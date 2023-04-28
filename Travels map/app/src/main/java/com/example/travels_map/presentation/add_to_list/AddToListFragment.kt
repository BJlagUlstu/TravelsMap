package com.example.travels_map.presentation.add_to_list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.travels_map.R
import com.example.travels_map.databinding.FragmentAddToListBinding
import com.example.travels_map.domain.models.PlaceType

class AddToListFragment : Fragment(R.layout.fragment_add_to_list) {

    private val binding by viewBinding(FragmentAddToListBinding::bind)

    private val placeAdapter = CheckablePlaceAdapter(object : CheckablePlacesListViewHolder.CheckablePlacesListViewListener {
        override fun onLayoutClick(placeType: PlaceType) { }

        override fun onCheckboxClick(placeType: PlaceType) { }
    })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews()
    }

    private fun initializeViews() {
        setupRecyclerView()
        setupToolbar()
    }

    private fun setupToolbar() {
        with(binding) {
            toolbar.setNavigationOnClickListener { findNavController().navigateUp() }

            textViewDone.setOnClickListener { findNavController().navigateUp() }
        }
    }

    private fun setupRecyclerView() {
        binding.placesListRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = placeAdapter
        }

        preInit()
    }

    private fun preInit() {
        val list = mutableListOf<PlaceType>()

        for (i in 0..15) {
            list.add(PlaceType(i, "Name #$i", 5, listOf()))
        }

        placeAdapter.submitList(list)
    }
}