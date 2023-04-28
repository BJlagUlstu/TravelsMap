package com.example.travels_map.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

private const val LANGUAGE = "ru"
private const val UNITS = "metric"
private const val API_KEY = "AIzaSyCo0gUCB7n4j_w4f7oYHmRcOwE95Eea0EE"

interface DirectionsAPI {

    @GET("directions/json")
    suspend fun getDirections(
        @Query("origin") origin: String,
        @Query("destination") destination: String,
        @Query("waypoints") waypoints: String,
        @Query("language") language: String = LANGUAGE,
        @Query("units") units: String = UNITS,
        @Query("key") key: String = API_KEY,
    ) : Response<DirectionsResponse>
}