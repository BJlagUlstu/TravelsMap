package com.example.travels_map.presentation.manage_shortcut

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.travels_map.R
import com.example.travels_map.databinding.FragmentManageShortcutBottomSheetBinding
import com.example.travels_map.presentation.explore.ExploreFragmentDirections
import com.example.travels_map.presentation.manage_shortcut.overview.OverviewFragment
import com.example.travels_map.presentation.manage_shortcut.photo.PhotoFragment
import com.example.travels_map.presentation.manage_shortcut.reviews.ReviewsFragment
import com.google.android.material.tabs.TabLayoutMediator

class ManageShortcutBottomSheetFragment : Fragment(R.layout.fragment_manage_shortcut_bottom_sheet) {

    private val binding by viewBinding(FragmentManageShortcutBottomSheetBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews()
    }

    private fun initializeViews() {
        setupShortcutInfoAdapter()
        setupOnClickListeners()
    }

    private fun setupOnClickListeners() {
        with(binding) {
            routeChip.setOnClickListener { }

            saveChip.setOnClickListener {
                findNavController().navigate(ExploreFragmentDirections.actionNavigationExploreToAddToListFragment())
            }

            shortcutChip.setOnClickListener {
                findNavController().navigate(ExploreFragmentDirections.actionNavigationExploreToManageTitleFragment(
                    MANAGE_SHORTCUT_TITLE_REQUEST_KEY,
                    MANAGE_SHORTCUT_TITLE_BUNDLE_KEY,
                ))
            }
        }
    }

    private fun setupShortcutInfoAdapter() {
        val fragments = listOf(OverviewFragment(), ReviewsFragment(), PhotoFragment())
        val shortcutInfoAdapter = ShortcutInfoAdapter(fragments, childFragmentManager, lifecycle)

        with(binding) {
            shortcutInfoViewPager.adapter = shortcutInfoAdapter

            TabLayoutMediator(tabLayout, shortcutInfoViewPager) { tab, position ->
                tab.text = fragments[position].title
            }.attach()
        }
    }

    companion object {
        const val MANAGE_SHORTCUT_TITLE_REQUEST_KEY = "MANAGE_SHORTCUT_TITLE_REQUEST_KEY"
        const val MANAGE_SHORTCUT_TITLE_BUNDLE_KEY = "MANAGE_SHORTCUT_TITLE_BUNDLE_KEY"
    }
}