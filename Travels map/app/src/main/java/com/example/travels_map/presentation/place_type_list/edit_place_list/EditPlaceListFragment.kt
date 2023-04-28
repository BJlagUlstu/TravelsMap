package com.example.travels_map.presentation.place_type_list.edit_place_list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.travels_map.R
import com.example.travels_map.databinding.FragmentEditPlaceListBinding
import com.example.travels_map.domain.models.Place
import com.yandex.mapkit.geometry.Point

class EditPlaceListFragment : Fragment(R.layout.fragment_edit_place_list) {

    private val binding by viewBinding(FragmentEditPlaceListBinding::bind)

    private val placeAdapter = RemovablePlaceAdapter { }

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
        val list = mutableListOf<Place>()

        for (i in 0..15) {
            list.add(Place(i, "Name #$i", Point(40.0, 50.0)))
        }

        placeAdapter.submitList(list)
    }
}