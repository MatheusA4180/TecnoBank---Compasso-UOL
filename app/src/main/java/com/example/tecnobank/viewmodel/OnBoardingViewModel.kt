package com.example.tecnobank.viewmodel


import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.example.tecnobank.R
import com.example.tecnobank.repository.OnBoardingRepository


class OnBoardingViewModel(context: Context) : ViewModel(){

    private val preferences : SharedPreferences = context.getSharedPreferences(
        R.string.preference_file_key.toString(), Context.MODE_PRIVATE)

    private val repository by lazy{
        OnBoardingRepository(preferences)
    }

    fun primeiraVez(){
        repository.entrou()
    }

    fun vezesSubsequentes(): Boolean = repository.jaentrou()
}