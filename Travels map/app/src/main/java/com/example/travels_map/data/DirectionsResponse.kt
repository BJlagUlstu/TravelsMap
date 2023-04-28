package com.example.travels_map.data

import com.google.gson.annotations.SerializedName

data class DirectionsResponse(
    @SerializedName("routes") val routes: List<DirectionsRoute>,
    @SerializedName("status") val status: DirectionsStatus,
    @SerializedName("error_message") val errorMessage: String,
)

data class DirectionsRoute(
    @SerializedName("legs") val legs: List<DirectionsLeg>,
    @SerializedName("overview_polyline") val overviewPolyline: DirectionsPolyline,
    @SerializedName("summary") val summary: String,
    @SerializedName("warnings") val warnings: List<String>,
    @SerializedName("waypoint_order") val waypointOrder: List<Int>,
)

data class DirectionsLeg(
    @SerializedName("end_address") val endAddress: String,
    @SerializedName("end_location") val endLocation: LatLngLiteral,
    @SerializedName("start_address") val startAddress: String,
    @SerializedName("start_location") val startLocation: LatLngLiteral,
    @SerializedName("steps") val steps: List<DirectionsStep>,
    @SerializedName("distance") val distance: TextValueObject,
    @SerializedName("duration") val duration: TextValueObject,
)

data class DirectionsStep(
    @SerializedName("duration") val duration: TextValueObject,
    @SerializedName("end_location") val endLocation: LatLngLiteral,
    @SerializedName("html_instructions") val htmlInstructions: String,
    @SerializedName("polyline") val polyline: DirectionsPolyline,
    @SerializedName("start_location") val startLocation: LatLngLiteral,
    @SerializedName("travel_mode") val travelMode: TravelMode,
    @SerializedName("distance") val distance: TextValueObject,
)

data class TextValueObject(
    @SerializedName("text") val text: String,
    @SerializedName("value") val value: Number,
)

data class LatLngLiteral(
    @SerializedName("lat") val latitude: Double,
    @SerializedName("lon") val longitude: Double,
)

data class DirectionsPolyline(
    @SerializedName("points") val points: String,
)

enum class DirectionsStatus {
    OK,
    NOT_FOUND,
    ZERO_RESULTS,
    MAX_WAYPOINTS_EXCEEDED,
    MAX_ROUTE_LENGTH_EXCEEDED,
    INVALID_REQUEST,
    OVER_DAILY_LIMIT,
    OVER_QUERY_LIMIT,
    REQUEST_DENIED,
    UNKNOWN_ERROR,
}

enum class TravelMode {
    DRIVING,
    BICYCLING,
    TRANSIT,
    WALKING,
}