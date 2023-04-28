package com.example.travels_map.presentation.explore.map_controller

import com.example.travels_map.domain.models.Route
import com.example.travels_map.domain.models.Shortcut
import com.example.travels_map.presentation.TravelsMapApplication
import com.yandex.mapkit.geometry.Polyline
import com.yandex.mapkit.map.Map
import com.yandex.runtime.image.ImageProvider

class MapController(private val map: Map, callback: (boolean: Boolean) -> Unit) {

    private val defaultController = DefaultController(map, callback)
    private val routeConfigurationController = RouteConfigurationController(map)

    private val controllers = listOf(defaultController, routeConfigurationController)

    init {
        activateMapController(defaultController)
    }

    fun activateRouteConfigurationMode() {
        deactivateMapController(defaultController)
        activateMapController(routeConfigurationController)
    }

    fun deactivateRouteConfigurationMode() {
        deactivateMapController(routeConfigurationController)
        activateMapController(defaultController)
    }

    private fun deactivateMapController(controller: IMapController) {
        map.removeInputListener(controller)

        map.removeTapListener(controller)

        controllers.forEach {
            it.getPlaceMarkCollection().removeTapListener(controller)
        }
    }

    private fun activateMapController(controller: IMapController) {
        map.addInputListener(controller)

        map.addTapListener(controller)

        controllers.forEach {
            it.getPlaceMarkCollection().addTapListener(controller)
        }
    }

    fun showShortcuts(shortcuts: List<Shortcut>) {
        with(defaultController.getPlaceMarkCollection()) {
            clear()
            shortcuts.forEach {
                addPlacemark(
                    it.point,
                    ImageProvider.fromAsset(TravelsMapApplication.INSTANCE, "moon.png"),
                )
            }
        }
    }

    fun showRoutes(routes: List<Route>) {
        with(defaultController.getPolylineCollection()) {
            clear()
            routes.forEach {
                addPolyline(Polyline(it.points))
            }
        }
    }

    fun calculatePreliminaryRoute() = routeConfigurationController.calculatePreliminaryRoute()
}