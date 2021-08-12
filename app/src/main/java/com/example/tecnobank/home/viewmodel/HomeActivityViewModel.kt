package com.example.tecnobank.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecnobank.data.remote.model.home.TokenFirebase
import com.example.tecnobank.home.repository.HomeActivityRepository
import kotlinx.coroutines.launch

class HomeActivityViewModel(
    private val homeActivityRepository: HomeActivityRepository
) : ViewModel() {

    private val _responseSuccess = MutableLiveData<Void>()
    val responseSuccess: LiveData<Void> = _responseSuccess

    private val _responseError = MutableLiveData<String>()
    val responseError: LiveData<String> = _responseError

    fun sendToken(tokenFirebase: TokenFirebase) {
        viewModelScope.launch {
            try {
                val response = homeActivityRepository.sendToken(tokenFirebase)
                _responseSuccess.postValue(response)
            } catch (e: Exception) {
                _responseError.postValue(e.message)
            }
        }
    }

}