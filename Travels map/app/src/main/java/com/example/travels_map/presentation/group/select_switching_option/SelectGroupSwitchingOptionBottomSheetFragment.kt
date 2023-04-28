package com.example.travels_map.presentation.group.select_switching_option

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.travels_map.databinding.FragmentSelectGroupSwitchingOptionBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SelectGroupSwitchingOptionBottomSheetFragment : BottomSheetDialogFragment() {

    private val binding: FragmentSelectGroupSwitchingOptionBottomSheetBinding by viewBinding(CreateMethod.INFLATE)

    private val directions = SelectGroupSwitchingOptionBottomSheetFragmentDirections

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews()
    }

    private fun initializeViews() {
        setupOnClickListeners()
    }

    private fun setupOnClickListeners() {
        with(binding) {
            textViewCreateGroup.setOnClickListener {
                findNavController().navigate(
                    directions.actionSelectGroupSwitchingOptionBottomSheetFragmentToManageTitleFragment(
                        CREATE_GROUP_REQUEST_KEY,
                        CREATE_GROUP_BUNDLE_KEY,
                    )
                )
            }

            textViewFindGroup.setOnClickListener {
                findNavController().navigate(
                    directions.actionSelectGroupSwitchingOptionBottomSheetFragmentToFindGroupFragment()
                )
            }

            textViewSelectGroup.setOnClickListener {
                findNavController().navigate(
                    directions.actionSelectGroupSwitchingOptionBottomSheetFragmentToGroupListFragment()
                )
            }
        }
    }

    private companion object {
        const val CREATE_GROUP_REQUEST_KEY = "CREATE_GROUP_REQUEST_KEY"
        const val CREATE_GROUP_BUNDLE_KEY = "CREATE_GROUP_BUNDLE_KEY"
    }
}