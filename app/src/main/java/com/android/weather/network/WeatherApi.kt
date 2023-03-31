package com.android.weather.network

import com.android.weather.network.model.WeatherByCurrentLocModel
import com.android.weather.utils.Configs.Companion.WEATHER
import retrofit2.Response
import retrofit2.http.*

interface WeatherApi {
    @GET(WEATHER)
    suspend fun getWeatherByCityStateCode(
        @QueryMap options: Map<String, String>
    ): Response<WeatherByCurrentLocModel.Response>

    @GET(WEATHER)
    suspend fun getCurrentLocWeather(
        @QueryMap options: Map<String, String>
    ): Response<WeatherByCurrentLocModel.Response>

}