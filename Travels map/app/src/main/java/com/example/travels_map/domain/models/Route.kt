package com.example.travels_map.domain.models

import com.yandex.mapkit.geometry.Point

data class Route(
    val tag: String,
    val points: List<Point>,
)