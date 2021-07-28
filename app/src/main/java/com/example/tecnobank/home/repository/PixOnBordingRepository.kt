package com.example.tecnobank.home.repository

import com.example.tecnobank.data.local.SharedPreferenceServices

class PixOnBordingRepository(
    private val sharedPreferenceServices: SharedPreferenceServices
) {

    fun saveUserPassPixOnboarding() = sharedPreferenceServices.saveUserPassPixOnboarding()

    fun passedByPixOnBoarding(): Boolean = sharedPreferenceServices.passedByPixOnBoarding()

}