package com.example.tecnobank.intro.viewmodel

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tecnobank.R
import com.example.tecnobank.intro.data.remote.EndPoint
import com.example.tecnobank.intro.repository.LoginRepository
import com.example.tecnobank.intro.repository.OnBoardingRepository
import com.example.tecnobank.intro.repository.SaveUserRepository
import com.example.tecnobank.intro.repository.SplashRepository
import java.lang.Exception

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
        if(modelClass== SaveUserViewModel::class.java){
            return providerSaveUserViewModel() as T
        }
        throw Exception("ViewModel não encotrado")
    }

    private fun providerSaveUserViewModel(): SaveUserViewModel {
        return SaveUserViewModel(SaveUserRepository(providerSharedPreference()))
    }

    private fun providerSplashViewModel(): SplashViewModel {
        return SplashViewModel(SplashRepository(providerSharedPreference()))
    }

    private fun providerOnBoardingViewModel(): OnBoardingViewModel {
        return OnBoardingViewModel(OnBoardingRepository(providerSharedPreference()))
    }

    private fun providerLoginViewModel(): LoginViewModel{
        return LoginViewModel(LoginRepository(providerRetrofitInstance()))
    }

    private fun providerRetrofitInstance():EndPoint {
        return EndPoint.getRetrofitInstance()
    }

    private fun providerSharedPreference(): SharedPreferences {
        return context.getSharedPreferences(
            R.string.preference_file_key.toString(), Context.MODE_PRIVATE
        )
    }
}