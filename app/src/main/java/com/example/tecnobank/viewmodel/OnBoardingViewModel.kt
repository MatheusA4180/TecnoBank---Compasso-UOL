package com.example.tecnobank.viewmodel

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.tecnobank.MainActivity
import com.example.tecnobank.R
import com.example.tecnobank.repository.OnBoardingRepository


class OnBoardingViewModel(context: Context) : ViewModel(){

    private val repository by lazy{
        OnBoardingRepository(context)
    }

    fun primeiraVez(){
        repository.entrou()
    }

    fun vezesSubsequentes(): Boolean = repository.jaentrou()
}