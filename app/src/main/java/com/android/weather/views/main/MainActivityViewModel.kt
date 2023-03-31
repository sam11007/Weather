package com.android.weather.views.main

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
class MainActivityViewModel @Inject constructor(

) : ViewModel() {

}