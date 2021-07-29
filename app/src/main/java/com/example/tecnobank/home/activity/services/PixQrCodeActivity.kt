package com.example.tecnobank.home.activity.services

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import com.example.tecnobank.R
import com.example.tecnobank.data.local.SharedPreferenceServices
import com.example.tecnobank.data.remote.EndPoint
import com.example.tecnobank.databinding.PixQrCodeActivityBinding
import com.example.tecnobank.home.viewmodel.PixViewModel
import com.example.tecnobank.viewmodelfactory.ViewModelFactory

class PixQrCodeActivity : AppCompatActivity() {

    private lateinit var binding: PixQrCodeActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val sharedPreferenceServices = providerSharedPreferenceService(providerSharedPreference())

        binding = PixQrCodeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            (supportFragmentManager.findFragmentById(R.id.navHostFragmentPix) as NavHostFragment)
        val inflater = navHostFragment.navController.navInflater
        val graph = inflater.inflate(R.navigation.pix_qr_code_nav_graph)

        if(sharedPreferenceServices.passedByPixOnBoarding()) {
            graph.startDestination = R.id.pixQrCodeFragment

        }else{
            graph.startDestination = R.id.pixOnBordingFragment
        }

        navHostFragment.navController.graph = graph

    }

    private fun providerSharedPreferenceService(
        preferences: SharedPreferences
    ): SharedPreferenceServices {
        return SharedPreferenceServices(preferences)
    }

    private fun providerSharedPreference(): SharedPreferences {
        return this.getSharedPreferences(
            R.string.preference_file_key.toString(), Context.MODE_PRIVATE
        )
    }
}
