package com.example.tecnobank.intro.viewmodel

import androidx.lifecycle.ViewModel
import com.example.tecnobank.intro.repository.SplashRepository

class SplashViewModel(private val repository: SplashRepository):ViewModel() {

    fun hasPassed():Boolean{
        return repository.passed()
    }

}