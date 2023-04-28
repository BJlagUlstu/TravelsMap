package com.example.travels_map.presentation.manage_shortcut

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class TabFragment(@LayoutRes contentLayoutId: Int) : Fragment(contentLayoutId) {

    abstract val title: String
}