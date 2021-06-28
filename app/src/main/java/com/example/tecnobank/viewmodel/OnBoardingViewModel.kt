package com.example.tecnobank.viewmodel


import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tecnobank.R
import com.example.tecnobank.repository.OnBoardingRepository


class OnBoardingViewModel(private val repository: OnBoardingRepository) : ViewModel(){
    fun primeiraVez(){
        repository.entrou()
    }

    fun vezesSubsequentes(): Boolean = repository.jaentrou()

}
