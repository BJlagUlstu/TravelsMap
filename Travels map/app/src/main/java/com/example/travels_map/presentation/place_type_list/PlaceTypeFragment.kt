package com.example.travels_map.presentation.place_type_list

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.travels_map.R
import com.example.travels_map.databinding.FragmentPlaceTypeListBinding
import com.example.travels_map.domain.models.PlaceType

class PlaceTypeFragment : Fragment(R.layout.fragment_place_type_list) {

    private val binding by viewBinding(FragmentPlaceTypeListBinding::bind)

    private val placeTypeAdapter = PlaceTypeAdapter(object : PlaceTypeViewHolder.SavedListViewListener {
        override fun onLayoutClick(placeType: PlaceType) {}

        override fun onMoreButtonClick(placeType: PlaceType, view: View) {
            showPopupMenu(view)
        }
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupFragmentResultListeners()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews()
    }

    private fun setupFragmentResultListeners() {
        setFragmentResultListener(CREATE_LIST_REQUEST_KEY) { _, bundle ->
            Toast.makeText(
                requireContext(),
                bundle.getString(CREATE_LIST_BUNDLE_KEY),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun initializeViews() {
        setupRecyclerView()
        setupToolbar()
    }

    private fun setupToolbar() {
        binding.textViewAddNewList.setOnClickListener {
            findNavController().navigate(
                PlaceTypeFragmentDirections.actionNavigationSavedToManageTitleFragment(
                    CREATE_LIST_REQUEST_KEY,
                    CREATE_LIST_BUNDLE_KEY,
                )
            )
        }
    }

    private fun setupRecyclerView() {
        binding.listOfPlacesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = placeTypeAdapter
        }

        preInit()
    }

    private fun preInit() {
        val list = mutableListOf<PlaceType>()

        for (i in 0..15) {
            list.add(PlaceType(i, "Name #$i", 5, listOf()))
        }

        placeTypeAdapter.submitList(list)
    }

    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(requireContext(), view).apply {
            menuInflater.inflate(R.menu.place_menu, this.menu)

            setOnMenuItemClickListener {
                return@setOnMenuItemClickListener when (it.itemId) {
                    R.id.item_edit_list -> {
                        dismiss()
                        findNavController().navigate(PlaceTypeFragmentDirections.actionNavigationSavedToEditLocationListFragment())
                        true
                    }
                    R.id.item_delete_list -> {
                        dismiss()
                        findNavController().navigateUp()
                        true
                    }
                    else -> false
                }
            }
        }

        popupMenu.show()
    }

    private companion object {
        const val CREATE_LIST_REQUEST_KEY = "CREATE_LIST_REQUEST_KEY"
        const val CREATE_LIST_BUNDLE_KEY = "CREATE_LIST_BUNDLE_KEY"
    }
}