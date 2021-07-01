package com.example.tecnobank.home.viewmodel

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tecnobank.R
import com.example.tecnobank.home.data.remote.EndPointHome
import com.example.tecnobank.home.repository.InicioRepository
import com.example.tecnobank.intro.repository.OnBoardingRepository
import com.example.tecnobank.intro.viewmodel.OnBoardingViewModel
import java.lang.Exception

class ViewModelFactoryHome(): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass== InicioViewModel::class.java){
            return providerInicioViewModel() as T
        }
        throw Exception("ViewModel não encotrado")
    }

    private fun providerInicioViewModel(): InicioViewModel {
        return InicioViewModel(InicioRepository(providerRetrofitInstance()))
    }

    private fun providerRetrofitInstance():EndPointHome {
        return EndPointHome.getRetrofitInstance()
    }

}