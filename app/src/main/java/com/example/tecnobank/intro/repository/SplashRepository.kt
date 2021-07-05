package com.example.tecnobank.intro.repository

import com.example.tecnobank.intro.data.local.SharedPreferenceServices

class SplashRepository(private val sharedPreferenceServices: SharedPreferenceServices) {

    fun passedByTheOnBoarding(): Boolean = sharedPreferenceServices.passedByTheOnBoarding()

}
