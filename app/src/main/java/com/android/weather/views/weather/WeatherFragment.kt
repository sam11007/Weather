package com.android.weather.views.weather

import android.Manifest
import android.content.pm.PackageManager
import android.location.Criteria
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.android.weather.R
import com.android.weather.databinding.FragmentWeatherBinding
import com.android.weather.utils.WEATHER_TYPE
import com.android.weather.utils.networkUtil.NetworkResource


import com.android.weather.views.base.BaseFragment


import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class WeatherFragment : BaseFragment<FragmentWeatherBinding>(), LocationListener {
    private val weatherViewModel: WeatherViewModel by viewModels()
    private var lat: Double? = null
    private var lng: Double? = null
    private var permissionArrays = arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION)

    private val dialog by lazy {
        progressDialog("Loading....")
    }


    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentWeatherBinding {
        return FragmentWeatherBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.viewModel = weatherViewModel
        binding?.lifecycleOwner = this
        dataObserver()
        //set Permission
        val MyVersion = Build.VERSION.SDK_INT
        if (MyVersion > Build.VERSION_CODES.LOLLIPOP_MR1) {
            if (checkIfAlreadyhavePermission() && checkIfAlreadyhavePermission2()) {
            } else {
                requestPermissions(permissionArrays, 101)
            }
        }
        binding?.search?.setOnClickListener{
            val cityName = binding?.etCityName?.text.toString()
            weatherViewModel.findGeoLoc(cityName)
        }
    }
    private fun checkIfAlreadyhavePermission(): Boolean {
        val result = ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION)
        return result == PackageManager.PERMISSION_GRANTED
    }

    private fun checkIfAlreadyhavePermission2(): Boolean {
        val result = ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION)
        return result == PackageManager.PERMISSION_GRANTED
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        for (grantResult in grantResults) {
            if (grantResult == PackageManager.PERMISSION_DENIED) {
//                val intent = intent
//                finish()
//                startActivity(intent)
            } else {
                getLatlong()
            }
        }
    }

    override fun onStatusChanged(s: String, i: Int, bundle: Bundle) {}
    override fun onProviderEnabled(s: String) {}
    override fun onProviderDisabled(s: String) {}
    private fun getLatlong() {
        if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) !=
            PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) !=
            PackageManager.PERMISSION_GRANTED) {
            activity?.let { ActivityCompat.requestPermissions(it, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 115) }
            return
        }
        val locationManager = activity?.getSystemService(AppCompatActivity.LOCATION_SERVICE) as LocationManager
        val criteria = Criteria()
        val provider = locationManager.getBestProvider(criteria, true)
        provider?.let {
            val location = locationManager.getLastKnownLocation(it)
            if (location != null) {
                onLocationChanged(location)
            } else {
                locationManager.requestLocationUpdates(it, 20000, 0f, this)
            }
        }

    }

    override fun onLocationChanged(location: Location) {
        lng = location.longitude
        lat = location.latitude
        lng?.let { lng->
            lat?.let {  lat->
                weatherViewModel.demoApiCall(lng, lat)
            }
        }
    }

    private fun dataObserver() {
        weatherViewModel.weatherByCurrentLoc.observe(viewLifecycleOwner) { response ->
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
                        val windSpeed = weatherData?.wind?.speed
                        val humidity = weatherData?.main?.humidity
                        val name = weatherData?.name
                        when(weatherDescription){
                            WEATHER_TYPE.BROKEN_CLOUDS.type -> {
                                binding?.iconTemp?.setAnimation(R.raw.broken_clouds)
                            }
                            WEATHER_TYPE.LIGHT_RAIN.type -> {
                                binding?.iconTemp?.setAnimation(R.raw.broken_clouds)
                            }
                            WEATHER_TYPE.HAZE.type -> {
                                binding?.iconTemp?.setAnimation(R.raw.broken_clouds)
                            }
                            WEATHER_TYPE.OVERCAST_CLOUDS.type -> {
                                binding?.iconTemp?.setAnimation(R.raw.broken_clouds)
                            }
                            WEATHER_TYPE.MODERATE_RAIN.type -> {
                                binding?.iconTemp?.setAnimation(R.raw.broken_clouds)
                            }
                            WEATHER_TYPE.FEW_CLOUDS.type -> {
                                binding?.iconTemp?.setAnimation(R.raw.broken_clouds)
                            }
                            WEATHER_TYPE.HEAVY_INTENSITY_RAIN.type -> {
                                binding?.iconTemp?.setAnimation(R.raw.broken_clouds)
                            }
                            WEATHER_TYPE.CLEAR_SKY.type -> {
                                binding?.iconTemp?.setAnimation(R.raw.broken_clouds)
                            }
                            WEATHER_TYPE.SCATTERED_CLOUDS.type -> {
                                binding?.iconTemp?.setAnimation(R.raw.broken_clouds)
                            }
                        }
                        binding?.tvWeather?.text = weatherDescription
                        binding?.tvName?.text = name
                        binding?.tvTempeature?.text = String.format("%.0f°C", temperature)
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
        weatherViewModel.findGeoLoc.observe(viewLifecycleOwner) { response ->
            response?.let {
                when (it) {
                    is NetworkResource.Loading -> {
                        dialog.show()
                    }
                    is NetworkResource.Success -> {
                        dialog.dismiss()
                       val location = response.data?.get(0)
                        lng = location?.lon
                        lat = location?.lat
                        lng?.let { lng->
                            lat?.let {  lat->
                                weatherViewModel.demoApiCall(lng, lat)
                            }
                        }
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