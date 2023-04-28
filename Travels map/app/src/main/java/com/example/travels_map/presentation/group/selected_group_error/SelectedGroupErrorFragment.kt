package com.example.travels_map.presentation.group.selected_group_error

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.travels_map.R
import com.example.travels_map.databinding.FragmentSelectedGroupErrorBinding

class SelectedGroupErrorFragment : Fragment(R.layout.fragment_selected_group_error) {

    private val binding by viewBinding(FragmentSelectedGroupErrorBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews()
    }

    private fun initializeViews() {
        setupOnClickListeners()
    }

    private fun setupOnClickListeners() {
        with(binding) {
            createGroupButton.setOnClickListener {
                findNavController().navigate(
                    SelectedGroupErrorFragmentDirections.actionSelectedGroupErrorFragmentToManageTitleFragment(
                        CREATE_GROUP_REQUEST_KEY,
                        CREATE_GROUP_BUNDLE_KEY,
                    )
                )
            }

            findGroupButton.setOnClickListener {
                findNavController().navigate(SelectedGroupErrorFragmentDirections.actionSelectedGroupErrorFragmentToFindGroupFragment())
            }
        }
    }

    private companion object {
        const val CREATE_GROUP_REQUEST_KEY = "CREATE_GROUP_REQUEST_KEY"
        const val CREATE_GROUP_BUNDLE_KEY = "CREATE_GROUP_BUNDLE_KEY"
    }
}