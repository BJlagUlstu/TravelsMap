package com.example.travels_map.presentation.account.edit_profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.travels_map.R
import com.example.travels_map.databinding.FragmentEditProfileBinding

class EditProfileFragment : Fragment(R.layout.fragment_edit_profile) {

    private val binding by viewBinding(FragmentEditProfileBinding::bind)

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

            textViewDone.setOnClickListener { findNavController().navigateUp() }
        }
    }

    private fun setupOnClickListeners() {
        with(binding) {
            textViewEditProfilePhoto.setOnClickListener { findNavController().navigateUp() }

            saveButton.setOnClickListener { findNavController().navigateUp() }
        }
    }
}