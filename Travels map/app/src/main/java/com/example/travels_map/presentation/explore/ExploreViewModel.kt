package com.example.travels_map.presentation.explore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.travels_map.domain.models.Route
import com.example.travels_map.domain.models.Shortcut
import com.parse.ParseObject

class ExploreViewModel : ViewModel() {

    private val _routes = MutableLiveData<List<Route>>()
    val routes: LiveData<List<Route>> = _routes

    private val _shortcuts = MutableLiveData<List<Shortcut>>()
    val shortcuts: LiveData<List<Shortcut>> = _shortcuts
}