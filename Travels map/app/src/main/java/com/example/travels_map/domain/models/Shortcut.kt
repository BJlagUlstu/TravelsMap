package com.example.travels_map.domain.models

import com.yandex.mapkit.geometry.Point

data class Shortcut(
    val id: Int,
    val title: String,
    val point: Point,
)