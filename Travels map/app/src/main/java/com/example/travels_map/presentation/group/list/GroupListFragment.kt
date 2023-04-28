package com.example.travels_map.presentation.group.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.travels_map.R
import com.example.travels_map.databinding.FragmentGroupListBinding
import com.example.travels_map.domain.models.Group

class GroupListFragment : Fragment(R.layout.fragment_group_list) {

    private val binding by viewBinding(FragmentGroupListBinding::bind)

    private val groupAdapter = GroupAdapter { }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews()
    }

    private fun initializeViews() {
        setupRecyclerView()
        setupToolbar()
    }

    private fun setupRecyclerView() {
        binding.groupsListRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = groupAdapter
        }

        preInit()
    }

    private fun setupToolbar() {
        with(binding) {
            toolbar.setNavigationOnClickListener { findNavController().navigateUp() }
        }
    }

    private fun preInit() {
        val list = mutableListOf<Group>()

        for (i in 0..15) {
            list.add(Group(i, "Group #$i", 5))
        }

        groupAdapter.submitList(list)
    }
}