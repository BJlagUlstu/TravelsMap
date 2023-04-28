package com.example.travels_map.domain.models

data class PlaceType(
    val id: Int,
    val name: String,
    val count: Int,
    val shortcuts: List<Shortcut>,
)