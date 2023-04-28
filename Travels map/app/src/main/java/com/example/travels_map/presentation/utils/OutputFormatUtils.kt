package com.example.travels_map.presentation.utils

import com.yandex.mapkit.geometry.Point

object OutputFormatUtils {

    fun Point.toText() = "$latitude, $longitude"
}