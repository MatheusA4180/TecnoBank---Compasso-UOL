package com.example.tecnobank.viewmodel

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tecnobank.R
import com.example.tecnobank.repository.OnBoardingRepository
import java.lang.Exception

class ViewModelFactory(private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass==OnBoardingViewModel::class.java){
            return providerOnBoardingViewModel() as T
        }
        throw Exception("ViewModel não encotrado")
    }

    private fun providerOnBoardingViewModel():OnBoardingViewModel{
        return OnBoardingViewModel(OnBoardingRepository(providerSharedPreference()))
    }

    private fun providerSharedPreference(): SharedPreferences {
        return context.getSharedPreferences(
            R.string.preference_file_key.toString(), Context.MODE_PRIVATE
        )
    }
}