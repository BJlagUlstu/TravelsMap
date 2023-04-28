package com.example.travels_map.presentation.group.add_participant

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.travels_map.R
import com.example.travels_map.databinding.FragmentAddParticipantBinding

class AddParticipantFragment : Fragment(R.layout.fragment_add_participant) {

    private val binding by viewBinding(FragmentAddParticipantBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews()
    }

    private fun initializeViews() {
        binding.textViewGroupID.text = "1234567890"

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
            textViewShare.setOnClickListener {  }

            textViewCopyIdentifier.setOnClickListener {  }
        }
    }
}