package com.example.tecnobank.intro.viewmodel


import androidx.lifecycle.ViewModel
import com.example.tecnobank.intro.repository.OnBoardingRepository


class OnBoardingViewModel(private val repository: OnBoardingRepository) : ViewModel(){
    fun primeiraVez(){
        repository.entrou()
    }

    fun vezesSubsequentes(): Boolean = repository.jaentrou()

}
