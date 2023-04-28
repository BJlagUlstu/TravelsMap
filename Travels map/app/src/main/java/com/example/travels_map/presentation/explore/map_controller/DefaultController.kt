package com.example.travels_map.presentation.explore.map_controller

import com.example.travels_map.presentation.TravelsMapApplication
import com.yandex.mapkit.Animation
import com.yandex.mapkit.GeoObject
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.layers.GeoObjectTapEvent
import com.yandex.mapkit.map.*
import com.yandex.mapkit.map.Map
import com.yandex.runtime.image.ImageProvider

class DefaultController(private val map: Map, private val callback: (boolean: Boolean) -> Unit) : IMapController {

    private val pointCollection = map.mapObjects.addCollection()
    private val routeCollection = map.mapObjects.addCollection()

    private var selectedGeoObject: GeoObject? = null
    private var selectedMapObject: MapObject? = null

    private var selectedObjectPoint: Point? = null

    override fun onMapTap(map: Map, point: Point) {
        deselect()
        callback(false)
    }

    override fun onMapLongTap(map: Map, point: Point) {
        if (!deselect()) {
            selectedMapObject = pointCollection.addPlacemark(
                point,
                ImageProvider.fromAsset(TravelsMapApplication.INSTANCE, "moon.png"),
            )
            selectedObjectPoint = point

            callback(true)

            updateCameraPosition(point)
        }
    }

    override fun onObjectTap(event: GeoObjectTapEvent): Boolean {
        val geoObject = event.geoObject
        val metadata = geoObject.metadataContainer.getItem(GeoObjectSelectionMetadata::class.java) ?: return false

        deselect()

        geoObject.geometry.first().point?.let { point ->
            if (geoObject != selectedGeoObject && point != selectedObjectPoint) {
                selectedGeoObject = geoObject
                selectedObjectPoint = point

                map.selectGeoObject(metadata.id, metadata.layerId)
                callback(true)

                updateCameraPosition(point)
            }
        }
        return true
    }

    override fun onMapObjectTap(mapObject: MapObject, clickPoint: Point): Boolean {
        if (!deselect()) {
            selectedMapObject = mapObject
            selectedObjectPoint = clickPoint
            callback(true)

            updateCameraPosition(clickPoint)
        }
        return true
    }

    override fun getPlaceMarkCollection(): MapObjectCollection = pointCollection

    override fun getPolylineCollection(): MapObjectCollection = routeCollection

    override fun onDeactivate() {
        deselect()
    }

    private fun deselect(): Boolean {
        if ((selectedGeoObject != null || selectedMapObject != null) && selectedObjectPoint != null) {
            selectedGeoObject = null
            selectedMapObject = selectedMapObject?.run {
                pointCollection.remove(this)
                return@run null
            }
            selectedObjectPoint = null

            map.deselectGeoObject()

            return true
        }
        return false
    }

    private fun updateCameraPosition(point: Point) {
        map.move(
            CameraPosition(
                point,
                map.cameraPosition.zoom,
                map.cameraPosition.azimuth,
                map.cameraPosition.tilt,
            ),
            Animation(Animation.Type.SMOOTH, 0.75f),
            null,
        )
    }
}