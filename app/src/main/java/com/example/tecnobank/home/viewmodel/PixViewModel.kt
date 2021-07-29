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
    private val _goToPix = MutableLiveData<Unit>()
    val goToPix: LiveData<Unit> = _goToPix

    fun onClickPixService(){
        if (pixRepository.passedByPixOnBoarding()) {
            _servicesToPix.postValue(Unit)
        } else {
            _servicesToPixOnBoarding.postValue(Unit)
        }
    }

    fun onClickStartPix(){
        pixRepository.saveUserPassPixOnboarding()
        _goToPix.postValue(Unit)
    }
}
