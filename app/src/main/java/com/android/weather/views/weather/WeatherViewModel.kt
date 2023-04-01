package com.android.weather.views.weather


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.weather.network.model.GeoModel
import com.android.weather.network.model.WeatherByCurrentLocModel
import com.android.weather.repository.WeatherRepository
import com.android.weather.utils.Configs
import com.android.weather.utils.networkUtil.NetworkHelper
import com.android.weather.utils.networkUtil.NetworkResource


import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.io.IOException

import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherRespository: WeatherRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {
    private val _weatherByCurrentLoc: MutableLiveData<NetworkResource<WeatherByCurrentLocModel.Response>> =
        MutableLiveData()
    val weatherByCurrentLoc: LiveData<NetworkResource<WeatherByCurrentLocModel.Response>> =
        _weatherByCurrentLoc
    fun demoApiCall(lng: Double, lat: Double) {
        viewModelScope.launch(Dispatchers.IO) {
            updateUI(NetworkResource.Loading())
            try {
                if (networkHelper.hasInternet()) {
                    val option = mutableMapOf<String, String>(
                        Pair("lat", lat.toString()),
                        Pair("lon", lng.toString()),
                        Pair("units","metric"),
                        Pair("appid", Configs.AppId)
                    )
                    val response =
                        weatherRespository.getCurrentLocWeather(option)
                    response?.let { weatherRes ->
                        val res = handleResponse(weatherRes)
                        updateUI(res)
                    }
                    updateUI(NetworkResource.LoadingEnd())
                } else {
                    updateUI(NetworkResource.Error("No Internet Connection"))
                }
            } catch (ex: Exception) {
                when (ex) {
                    is IOException -> updateUI(NetworkResource.Error("Network Failure"))
                    else -> updateUI(NetworkResource.Error("Conversion Error"))
                }
            }
        }
    }
    private fun handleResponse(response: Response<WeatherByCurrentLocModel.Response>)
            : NetworkResource<WeatherByCurrentLocModel.Response> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return NetworkResource.Success(resultResponse)
            }
        }else{
            return NetworkResource.Error(response.errorBody()?.string() ?: "ERROR")
        }
        return NetworkResource.Error(response.message())
    }

    private suspend fun updateUI(response: NetworkResource<WeatherByCurrentLocModel.Response>) {
        withContext(Dispatchers.Main) {
            _weatherByCurrentLoc.postValue(response)
        }
    }



    private val _findGeoLoc: MutableLiveData<NetworkResource<List<GeoModel.Response>>> =
        MutableLiveData()
    val findGeoLoc: LiveData<NetworkResource<List<GeoModel.Response>>> =
        _findGeoLoc
    fun findGeoLoc(cityName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            updateGEOUI(NetworkResource.Loading())
            try {
                if (networkHelper.hasInternet()) {

                    val response =
                        weatherRespository.getGeoLoc(cityName)
                    response?.let { weatherRes ->
                        val res = handleGEOResponse(weatherRes)
                        updateGEOUI(res)
                    }
                    updateGEOUI(NetworkResource.LoadingEnd())
                } else {
                    updateGEOUI(NetworkResource.Error("No Internet Connection"))
                }
            } catch (ex: Exception) {
                when (ex) {
                    is IOException -> updateGEOUI(NetworkResource.Error("Network Failure"))
                    else -> updateGEOUI(NetworkResource.Error("Conversion Error"))
                }
            }
        }
    }
    private fun handleGEOResponse(response: Response<List<GeoModel.Response>>)
            : NetworkResource<List<GeoModel.Response>> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return NetworkResource.Success(resultResponse)
            }
        }else{
            return  NetworkResource.Error(response.errorBody()?.string() ?: "ERROR")
        }
        return NetworkResource.Error(response.message())
    }

    private suspend fun updateGEOUI(response: NetworkResource<List<GeoModel.Response>>) {
        withContext(Dispatchers.Main) {
            _findGeoLoc.postValue(response)
        }
    }
}