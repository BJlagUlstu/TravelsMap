package com.example.travels_map.presentation.explore

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.travels_map.R
import com.example.travels_map.databinding.FragmentExploreBinding
import com.example.travels_map.presentation.explore.map_controller.MapController
import com.example.travels_map.presentation.manage_shortcut.ManageShortcutBottomSheetFragment
import com.example.travels_map.presentation.manage_shortcut.ShortcutInfoAdapter
import com.example.travels_map.presentation.manage_shortcut.overview.OverviewFragment
import com.example.travels_map.presentation.manage_shortcut.photo.PhotoFragment
import com.example.travels_map.presentation.manage_shortcut.reviews.ReviewsFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.tabs.TabLayoutMediator
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.directions.DirectionsFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView

class ExploreFragment : Fragment(R.layout.fragment_explore) {

    private lateinit var mapView: MapView

    private val binding by viewBinding(FragmentExploreBinding::bind)

    private val exploreViewModel: ExploreViewModel by activityViewModels()

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>

    private lateinit var mapController: MapController

    override fun onCreate(savedInstanceState: Bundle?) {
        MapKitFactory.setApiKey(getString(R.string.yandex_api_key))
        MapKitFactory.initialize(context)

        DirectionsFactory.initialize(context)

        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (binding.textViewDone.visibility == View.VISIBLE) {
                    binding.textViewDone.visibility = View.GONE
                    binding.manageShortcutBottomSheet.root.visibility = View.VISIBLE
                } else if (binding.manageShortcutBottomSheet.root.visibility == View.VISIBLE) {
                    binding.manageShortcutBottomSheet.root.visibility = View.GONE
                    mapController.deactivateRouteConfigurationMode()
                } else {
                    findNavController().navigateUp()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mapView = binding.mapView

        mapView.map.move(
            CameraPosition(Point(55.733330, 37.587649), 16f, 0f, 0f),
            Animation(Animation.Type.SMOOTH, 0f),
            null,
        )

        fun callback(boolean: Boolean) {
            if (boolean) {
                binding.manageShortcutBottomSheet.root.visibility = View.VISIBLE
            } else {
                binding.manageShortcutBottomSheet.root.visibility = View.GONE
            }
        }

        mapController = MapController(mapView.map, ::callback)

/*        with(binding) {
            start.setOnClickListener {
                it.visibility = View.INVISIBLE
                end.visibility = View.VISIBLE
                create.visibility = View.VISIBLE

                openManageShortcutBottomSheetFragment()
            }

            create.setOnClickListener {
                mapController.calculatePreliminaryRoute()
            }

            end.setOnClickListener {
                it.visibility = View.INVISIBLE
                create.visibility = View.INVISIBLE
                start.visibility = View.VISIBLE

                mapController.deactivateRouteConfigurationMode()
            }
        }*/

        setupManageShortcutBottomSheetFragment()

        exploreViewModel.routes.observe(viewLifecycleOwner) { routes ->
            mapController.showRoutes(routes)
        }

        exploreViewModel.shortcuts.observe(viewLifecycleOwner) { shortcuts ->
            mapController.showShortcuts(shortcuts)
        }

        binding.textViewDone.setOnClickListener {
            mapController.calculatePreliminaryRoute()
            binding.textViewDone.visibility = View.GONE
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }
    }

    private fun setupManageShortcutBottomSheetFragment() {
        bottomSheetBehavior = BottomSheetBehavior.from(binding.manageShortcutBottomSheet.root).apply {
            state = BottomSheetBehavior.STATE_COLLAPSED
            peekHeight = 400
        }

        with(binding.manageShortcutBottomSheet) {
            routeChip.setOnClickListener {
                mapController.activateRouteConfigurationMode()
                root.visibility = View.GONE
                binding.textViewDone.visibility = View.VISIBLE
            }

            saveChip.setOnClickListener {
                findNavController().navigate(ExploreFragmentDirections.actionNavigationExploreToAddToListFragment())
            }

            shortcutChip.setOnClickListener {
                findNavController().navigate(ExploreFragmentDirections.actionNavigationExploreToManageTitleFragment(
                    ManageShortcutBottomSheetFragment.MANAGE_SHORTCUT_TITLE_REQUEST_KEY,
                    ManageShortcutBottomSheetFragment.MANAGE_SHORTCUT_TITLE_BUNDLE_KEY,
                ))
            }

            root.visibility = View.GONE
        }

        setupShortcutInfoAdapter()
    }

    private fun setupShortcutInfoAdapter() {
        val fragments = listOf(OverviewFragment(), ReviewsFragment(), PhotoFragment())
        val shortcutInfoAdapter = ShortcutInfoAdapter(fragments, childFragmentManager, lifecycle)

        with(binding.manageShortcutBottomSheet) {
            shortcutInfoViewPager.adapter = shortcutInfoAdapter

            TabLayoutMediator(tabLayout, shortcutInfoViewPager) { tab, position ->
                tab.text = fragments[position].title
            }.attach()
        }
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        mapView.onStart()
    }

    override fun onStop() {
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }
}