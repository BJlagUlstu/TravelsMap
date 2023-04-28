package com.example.travels_map.presentation.manage_title

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.travels_map.R
import com.example.travels_map.databinding.FragmentManageTitleBinding

class ManageTitleFragment : Fragment(R.layout.fragment_manage_title) {

    private val args: ManageTitleFragmentArgs by navArgs()

    private val binding by viewBinding(FragmentManageTitleBinding::bind)

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

            textViewDone.setOnClickListener { done() }
        }
    }

    private fun setupOnClickListeners() {
        with(binding) {
            editTextName.setOnEditorActionListener { _, actionId, _ ->
                return@setOnEditorActionListener if (actionId == EditorInfo.IME_ACTION_DONE) {
                    done()
                    true
                } else {
                    false
                }
            }
        }
    }

    private fun done() {
        setFragmentResult(args.requestKey, bundleOf(args.bundleKey to binding.editTextName.text.toString()))
        findNavController().navigateUp()
    }
}