package com.example.tecnobank.intro.viewmodel

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tecnobank.R
import com.example.tecnobank.intro.data.local.SharedPreferenceServices
import com.example.tecnobank.intro.data.remote.EndPoint
import com.example.tecnobank.intro.repository.LoginRepository
import com.example.tecnobank.intro.repository.OnBoardingRepository
import com.example.tecnobank.intro.repository.SplashRepository

class ViewModelFactory(private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass== SplashViewModel::class.java){
            return providerSplashViewModel() as T
        }
        if(modelClass== OnBoardingViewModel::class.java){
            return providerOnBoardingViewModel() as T
        }
        if(modelClass== LoginViewModel::class.java){
            return providerLoginViewModel() as T
        }
        throw Exception("ViewModel não encotrado")
    }

    private fun providerSplashViewModel(): SplashViewModel {
        return SplashViewModel(
            SplashRepository(
                providerSharedPreferenceService(
                    providerSharedPreference()
                )
            )
        )
    }

    private fun providerOnBoardingViewModel(): OnBoardingViewModel {
        return OnBoardingViewModel(
            OnBoardingRepository(
                providerSharedPreferenceService(
                    providerSharedPreference()
                )
            )
        )
    }

    private fun providerLoginViewModel(): LoginViewModel {
        return LoginViewModel(
            LoginRepository(
                providerRetrofitInstance(),
                providerSharedPreferenceService(providerSharedPreference())
            )
        )
    }

    private fun providerSharedPreferenceService(preferences: SharedPreferences): SharedPreferenceServices {
        return SharedPreferenceServices(preferences)
    }

    private fun providerRetrofitInstance(): EndPoint {
        return EndPoint.getEndPointInstance()
    }

    private fun providerSharedPreference(): SharedPreferences {
        return context.getSharedPreferences(
            R.string.preference_file_key.toString(), Context.MODE_PRIVATE
        )
    }
}
