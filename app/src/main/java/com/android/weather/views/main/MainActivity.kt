package com.android.weather.views.main


import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.android.weather.R
import com.android.weather.databinding.ActivityMainBinding
import com.android.weather.utils.networkUtil.NetworkResource
import com.android.weather.views.base.BaseActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.main_nav_container)
        navView.setupWithNavController(navController)
    }

    override fun createBinding(): ActivityMainBinding {
       return ActivityMainBinding.inflate(layoutInflater)
    }
}
