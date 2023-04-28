package com.example.travels_map.presentation.manage_shortcut

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ShortcutInfoAdapter(
    fragments: List<Fragment>,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    private val list = fragments

    override fun getItemCount(): Int = list.size

    override fun createFragment(position: Int): Fragment = list[position]
}