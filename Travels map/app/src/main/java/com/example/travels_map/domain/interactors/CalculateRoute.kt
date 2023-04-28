package com.example.travels_map.domain.interactors

import android.util.Log
import com.example.travels_map.data.DirectionsAPI
import com.example.travels_map.data.RetrofitService

private const val BASE_URL = "https://maps.googleapis.com/maps/api/"

private val TAG = CalculateRoute::class.java.simpleName

class CalculateRoute {

    private val api = RetrofitService().getRetrofit(BASE_URL).create(DirectionsAPI::class.java)

    suspend fun run(origin: String, destination: String, waypoints: String) {
        try {
            val response = api.getDirections(origin, destination, "enc:$waypoints:")

            if (response.isSuccessful) {
                //
            } else {
                Log.e(TAG, response.errorBody().toString())
            }
        } catch (exception: Exception) {
            Log.e(TAG, exception.message.toString())
        }
    }
}