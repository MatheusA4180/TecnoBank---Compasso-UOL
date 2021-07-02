package com.example.tecnobank.intro.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecnobank.intro.data.remote.model.login.LoginResponse
import com.example.tecnobank.intro.repository.OnBoardingRepository
import kotlinx.coroutines.launch


class OnBoardingViewModel(private val repository: OnBoardingRepository) : ViewModel(){
    private val _firsttime = MutableLiveData<Boolean>()
    val firsttime: LiveData<Boolean> = _firsttime

    fun firstTime(){
        viewModelScope.launch {
            val response = repository.saveUserPassOnboarding()
            _firsttime.postValue(response)
        }
    }


}
