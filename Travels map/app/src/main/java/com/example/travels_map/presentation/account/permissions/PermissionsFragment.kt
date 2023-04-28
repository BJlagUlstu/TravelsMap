package com.example.travels_map.presentation.account.permissions

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.travels_map.R
import com.example.travels_map.databinding.FragmentPermissionsBinding

class PermissionsFragment : Fragment(R.layout.fragment_permissions) {

    private val binding by viewBinding(FragmentPermissionsBinding::bind)

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
            saveLoginDetailsLayout.setOnClickListener {  }

            saveLoginDetailsSwitch.setOnClickListener {  }

            allowDisplayLocationLayout.setOnClickListener {  }

            allowDisplayLocationSwitch.setOnClickListener {  }
        }
    }
}