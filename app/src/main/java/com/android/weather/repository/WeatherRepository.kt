package com.android.weather.repository

import android.provider.SyncStateContract.Constants
import android.util.Log
import com.android.weather.network.WeatherApi
import com.android.weather.network.model.WeatherByCurrentLocModel
import com.android.weather.utils.Configs
import retrofit2.Response
import javax.inject.Inject

class WeatherRepository @Inject constructor(
private val weatherApi: WeatherApi
){
    suspend fun getCurrentLocWeather(
        options: Map<String, String>,
    ): Response<WeatherByCurrentLocModel.Response>? {
        try {
            return weatherApi.getCurrentLocWeather(options)
        } catch (e: Exception) {
            e.message?.let { Log.d("TAG", it) }
        }
        return null
    }
    suspend fun getWeatherByCityStateCode(
        query: String,
    ): Response<WeatherByCurrentLocModel.Response>? {
        try {
            val option = mutableMapOf<String, String>(
                Pair("q", query),
                Pair("appid", Configs.AppId)
            )
            return weatherApi.getWeatherByCityStateCode(option)
        } catch (e: Exception) {
            e.message?.let { Log.d("TAG", it) }
        }
        return null
    }
}