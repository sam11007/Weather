package com.android.weather.views.weatherdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.android.weather.databinding.FragmentWeatherDetailsBinding
import com.android.weather.utils.networkUtil.NetworkResource


import com.android.weather.views.base.BaseFragment

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherDetailFragment : BaseFragment<FragmentWeatherDetailsBinding>() {
    private val viewModel: WeatherDetailViewModel by viewModels()
    private val dialog by lazy {
        progressDialog("Loading....")
    }
    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentWeatherDetailsBinding {
        return FragmentWeatherDetailsBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.viewModel = viewModel
        binding?.lifecycleOwner = this
        dataObserver()

        binding?.search?.setOnClickListener{
            val cityName = binding?.etCityName?.text.toString()
//            val  stateCode = binding?.etStateCode?.text.toString()
//            val  countryCode  = binding?.etCountryCode?.text.toString()
            viewModel.onSearch(cityName)
        }
    }
    private fun dataObserver() {
        viewModel.weatherDetails.observe(viewLifecycleOwner) { response ->
            response?.let {
                when (it) {
                    is NetworkResource.Loading -> {
                        dialog.show()
                    }
                    is NetworkResource.Success -> {
                        dialog.dismiss()
                        val weatherData = response.data
                        val weatherDescription = weatherData?.weather?.get(0)?.description
                        val mainData = weatherData?.main
                        val temperature = mainData?.temp
                        val mintemp = mainData?.temp_min
                        val maxtemp = mainData?.temp_max
                        val windSpeed = weatherData?.wind?.speed
                        val humidity = weatherData?.main?.humidity
                        val name = weatherData?.name

                        binding?.tvWeather?.text = weatherDescription
                        binding?.tvName?.text = name
                        binding?.tvTempeature?.text = String.format("%.0f°C", temperature)
                        binding?.tvTempMin?.text = "Min Temp: ${String.format("%.0f°C", mintemp)}"
                        binding?.tvTempMax?.text = "Max Temp: ${String.format("%.0f°C", maxtemp)}"
                        binding?.windSpeed?.text = "Wind Speed $windSpeed km/h"
                        binding?.tvhumidity?.text = "Humidity $humidity %"

                    }
                    is NetworkResource.Error -> {
                        dialog.dismiss()
                        showToast(response.message ?: "ERROR")
                    }
                    is NetworkResource.LoadingEnd -> {
                        dialog.dismiss()
                    }
                }
            }
        }
    }
}