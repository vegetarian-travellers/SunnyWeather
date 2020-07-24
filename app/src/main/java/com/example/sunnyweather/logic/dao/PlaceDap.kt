package com.example.sunnyweather.logic.dao

import android.content.Context
import androidx.core.content.edit
import com.example.sunnyweather.SunnyWeatherApplication
import com.example.sunnyweather.logic.model.Place
import com.google.gson.Gson

object PlaceDap {
    fun sacePlace(place :Place)
    {
        sharedPreference().edit {
            putString("place", Gson().toJson(place))
        }
    }
    fun getSaveedPloace():Place{
        val placeJson = sharedPreference().getString("place", "")
        return Gson().fromJson(placeJson, Place::class.java)
    }

    fun isPlaceSave() = sharedPreference().contains("place")

    private fun sharedPreference() = SunnyWeatherApplication.context.getSharedPreferences("sunny_weather", Context.MODE_PRIVATE)
}