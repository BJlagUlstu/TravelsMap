package com.example.travels_map.presentation

import android.app.Application
import android.content.Context
import com.example.travels_map.R
import com.parse.Parse

class TravelsMapApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        INSTANCE = this

        Parse.initialize(
            Parse.Configuration.Builder(this)
                .server(getString(R.string.back4app_server_url))
                .applicationId(getString(R.string.back4app_app_id))
                .clientKey(getString(R.string.back4app_client_key))
                .build()
        )
    }

    companion object {
        lateinit var INSTANCE : TravelsMapApplication
            private set
    }
}