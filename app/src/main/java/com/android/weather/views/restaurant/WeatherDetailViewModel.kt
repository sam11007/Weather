package com.android.weather.views.restaurant


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
class WeatherDetailViewModel @Inject constructor(
    private val weatherRespository: WeatherRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {
    private val _weatherDetails: MutableLiveData<NetworkResource<WeatherByCurrentLocModel.Response>> =
        MutableLiveData()
    val weatherDetails: LiveData<NetworkResource<WeatherByCurrentLocModel.Response>> =
        _weatherDetails
    fun onSearch(cityName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            updateUI(NetworkResource.Loading())
            try {
                if (networkHelper.hasInternet()) {

                    val response =
                        weatherRespository.getWeatherByCityStateCode(cityName)
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
            return  NetworkResource.Error(response.errorBody()?.string() ?: "ERROR")
        }
        return NetworkResource.Error(response.message())
    }

    private suspend fun updateUI(response: NetworkResource<WeatherByCurrentLocModel.Response>) {
        withContext(Dispatchers.Main) {
            _weatherDetails.postValue(response)
        }
    }
}