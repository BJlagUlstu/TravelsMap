package com.example.travels_map.presentation.group.find

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.travels_map.R
import com.example.travels_map.databinding.FragmentFindGroupBinding

class FindGroupFragment : Fragment(R.layout.fragment_find_group) {

    private val binding by viewBinding(FragmentFindGroupBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews()
    }

    private fun initializeViews() {
        setupOnClickListeners()
        setupToolbar()
    }

    private fun setupToolbar() {
        with(binding) {
            toolbar.setNavigationOnClickListener { findNavController().navigateUp() }
        }
    }

    private fun setupOnClickListeners() {
        with(binding) {
            editTextGroupName.setOnEditorActionListener { _, actionId, _ ->
                return@setOnEditorActionListener if (actionId == EditorInfo.IME_ACTION_SEND) {
                    findNavController().navigateUp()
                    true
                } else {
                    false
                }
            }

            joinButton.setOnClickListener { findNavController().navigateUp() }
        }
    }
}