package com.example.travels_map.presentation.group

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.travels_map.R
import com.example.travels_map.databinding.FragmentGroupBinding
import com.example.travels_map.domain.models.User

class GroupFragment : Fragment(R.layout.fragment_group) {

    private val binding by viewBinding(FragmentGroupBinding::bind)

    private val participantAdapter = ParticipantAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews()
    }

    private fun initializeViews() {
        with(binding) {
            textViewTitle.text = "Title"
            textViewNumberOfParticipants.text = "5 participants"
        }

        setupRecyclerView()
        setupOnClickListeners()
    }

    private fun setupOnClickListeners() {
        with(binding) {
            textViewAddParticipant.setOnClickListener {
                findNavController().navigate(GroupFragmentDirections.actionNavigationGroupToAddParticipantFragment())
            }

            textViewSwitchGroup.setOnClickListener {
                findNavController().navigate(GroupFragmentDirections.actionNavigationGroupToManageGroupBottomSheetFragment())
            }

            textViewExitTheGroup.setOnClickListener {
                findNavController().navigate(GroupFragmentDirections.actionNavigationGroupToSelectedGroupErrorFragment())
            }
        }
    }

    private fun setupRecyclerView() {
        binding.groupParticipantsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = participantAdapter
        }

        preInit()
    }

    private fun preInit() {
        val list = mutableListOf<User>()

        for (i in 0..15) {
            list.add(User(i, "Login #$i", "Password", "Name"))
        }

        participantAdapter.submitList(list)
    }
}