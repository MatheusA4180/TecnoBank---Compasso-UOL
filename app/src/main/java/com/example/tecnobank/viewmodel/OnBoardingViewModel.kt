package com.example.tecnobank.viewmodel

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.tecnobank.MainActivity
import com.example.tecnobank.R
import com.example.tecnobank.repository.OnBoardingRepository
import com.google.android.material.internal.ContextUtils.getActivity
import java.security.AccessController.getContext

class OnBoardingViewModel() : ViewModel(){

   private lateinit var preferences :SharedPreferences

    private val repository by lazy{
        OnBoardingRepository(preferences)
    }

//    fun setPreferences(preferences: SharedPreferences){
//        this.preferences = activity?.getSharedPreferences(
//            R.string.preference_file_key, Context.MODE_PRIVATE)
//    }

    fun primeiraVez(){
        repository.entrou()
    }

    fun vezesSubsequentes(): Boolean = repository.jaentrou()
}