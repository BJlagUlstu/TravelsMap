package com.example.travels_map.domain.models

import com.yandex.mapkit.geometry.Point

data class Place(
    val id: Int,
    val name: String,
    val coordinates: Point,
)