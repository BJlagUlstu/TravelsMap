package com.example.travels_map.presentation.explore.map_controller

import android.widget.Toast
import com.example.travels_map.R
import com.example.travels_map.presentation.TravelsMapApplication
import com.example.travels_map.presentation.utils.Alphabet
import com.example.travels_map.presentation.utils.MapUtils
import com.yandex.mapkit.Animation
import com.yandex.mapkit.RequestPoint
import com.yandex.mapkit.RequestPointType
import com.yandex.mapkit.directions.DirectionsFactory
import com.yandex.mapkit.directions.driving.DrivingOptions
import com.yandex.mapkit.directions.driving.DrivingRoute
import com.yandex.mapkit.directions.driving.DrivingSession.DrivingRouteListener
import com.yandex.mapkit.directions.driving.VehicleOptions
import com.yandex.mapkit.geometry.Geometry
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.geometry.Polyline
import com.yandex.mapkit.layers.GeoObjectTapEvent
import com.yandex.mapkit.map.*
import com.yandex.mapkit.map.Map
import com.yandex.runtime.Error
import com.yandex.runtime.image.ImageProvider
import com.yandex.runtime.network.NetworkError
import com.yandex.runtime.network.RemoteError

class RouteConfigurationController(private val map: Map) : IMapController, DrivingRouteListener {

    private val waypointCollection = map.mapObjects.addCollection()
    private val configurableRouteCollection = map.mapObjects.addCollection()

    private val points: MutableList<PlacemarkMapObject> = mutableListOf()

    private val drivingRouter = DirectionsFactory.getInstance().createDrivingRouter()

    override fun onMapTap(map: Map, point: Point) {
        addPoint(point)
    }

    override fun onMapLongTap(map: Map, point: Point) {
        addPoint(point)
    }

    override fun onObjectTap(event: GeoObjectTapEvent): Boolean {
        val point = event.geoObject.geometry.first().point ?: return false

        if (points.contains(point)) {
            removePoint(point)
        } else {
            addPoint(point)
        }
        return true
    }

    override fun onMapObjectTap(mapObject: MapObject, clickPoint: Point): Boolean {
        val point = mapObject.userData as Point

        if (points.contains(point)) {
            removePoint(point)
        } else {
            addPoint(point)
        }
        return true
    }

    override fun getPlaceMarkCollection(): MapObjectCollection = waypointCollection

    override fun getPolylineCollection(): MapObjectCollection = configurableRouteCollection

    override fun onDeactivate() {
        points.clear()
        waypointCollection.clear()
        configurableRouteCollection.clear()
    }

    override fun onDrivingRoutes(routes: MutableList<DrivingRoute>) {
        val drivingRoute = routes.minBy {
            it.metadata.weight.distance.value + it.metadata.weight.time.value + it.metadata.weight.timeWithTraffic.value
        }

        with(configurableRouteCollection) {
            clear()
            addPolyline(drivingRoute.geometry)
        }
        updateCameraPosition(drivingRoute.geometry)
    }

    override fun onDrivingRoutesError(error: Error) {
        val context = TravelsMapApplication.INSTANCE

        var errorMessage = context.getString(R.string.unknown_error_message)

        if (error is RemoteError) {
            errorMessage = context.getString(R.string.remote_error_message)
        } else if (error is NetworkError) {
            errorMessage = context.getString(R.string.network_error_message)
        }

        Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
    }

    private fun addPoint(point: Point) {
        val placeMark = waypointCollection.addPlacemark(
            point,
            ImageProvider.fromBitmap(
                MapUtils.Waypoint.drawBitmap(Alphabet.getAlphabetLetter(points.size))
            ),
        ).apply {
            userData = point
        }
        points.add(placeMark)
    }

    private fun removePoint(point: Point) {
        val indexedValue = points.withIndex().find {
            it.value.geometry.latitude == point.latitude && it.value.geometry.longitude == point.longitude
        } ?: return

        points.removeAt(indexedValue.index)

        waypointCollection.remove(indexedValue.value)

        for (i in indexedValue.index until points.size) {
            points[i].setIcon(
                ImageProvider.fromBitmap(
                    MapUtils.Waypoint.drawBitmap(Alphabet.getAlphabetLetter(i))
                )
            )
        }
    }

    private fun List<PlacemarkMapObject>.contains(point: Point): Boolean {
        val obj = find {
            it.geometry.latitude == point.latitude && it.geometry.longitude == point.longitude
        }
        return obj != null
    }

    fun calculatePreliminaryRoute() {
        val list = points.map {
            RequestPoint(it.geometry, RequestPointType.WAYPOINT, null)
        }
        drivingRouter.requestRoutes(list, DrivingOptions(), VehicleOptions(), this)
    }

    private fun updateCameraPosition(polyline: Polyline) {
        val cameraPosition = map.cameraPosition(
            Geometry.fromPolyline(polyline),
            map.cameraPosition.azimuth,
            map.cameraPosition.tilt,
            null,
        )

        map.move(
            CameraPosition(
                cameraPosition.target,
                cameraPosition.zoom * 0.95f,
                cameraPosition.azimuth,
                cameraPosition.tilt
            ),
            Animation(Animation.Type.SMOOTH, 0.75f),
            null,
        )
    }
}