package com.android.weather.utils

import com.android.weather.BuildConfig

class Configs {
    companion object {
        var BASEURL = "https://api.openweathermap.org"
        const val WEATHER = "/data/2.5/weather"
        const val GEO = "/geo/1.0/direct"
        var CurrentWeather = "weather?"
        val AppId = "190e4850367fb90afec4a45ec42be586"
        var loging: Boolean = true
        var debugMode : Boolean = BuildConfig.DEBUG
    }
}