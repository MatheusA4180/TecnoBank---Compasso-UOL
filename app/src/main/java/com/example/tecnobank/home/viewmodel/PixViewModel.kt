package com.example.tecnobank.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tecnobank.home.repository.PixRepository

class PixViewModel(private val pixRepository: PixRepository): ViewModel() {

    private val _servicesToPixOnBoarding = MutableLiveData<Unit>()
    val servicesToPixOnBoarding: LiveData<Unit> = _servicesToPixOnBoarding
    private val _servicesToPix = MutableLiveData<Unit>()
    val servicesToPix: LiveData<Unit> = _servicesToPix

    fun passedOrNoPassedForPixOnbording(){
        if (pixRepository.passedByPixOnBoarding()) {
            _servicesToPix.postValue(Unit)
        } else {
            _servicesToPixOnBoarding.postValue(Unit)
        }
    }

}
