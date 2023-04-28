package com.example.travels_map.domain.interactors

import android.util.Log
import com.example.travels_map.domain.models.Shortcut
import com.parse.ParseObject

private val TAG = CreateShortcutInteractor::class.java.simpleName

class CreateShortcutInteractor {

    fun run(shortcut: Shortcut) {
        val markerObject = ParseObject("Shortcut").apply {
            put("id", shortcut.id)
            put("title", shortcut.title)
            put("latitude", shortcut.point.latitude)
            put("longitude", shortcut.point.longitude)
        }

        markerObject.saveInBackground { callback ->
            callback?.message?.let { message -> Log.e(TAG, message) }
        }
    }
}