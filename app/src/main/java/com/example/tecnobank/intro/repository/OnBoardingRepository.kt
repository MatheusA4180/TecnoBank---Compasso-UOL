package com.example.tecnobank.intro.repository

import com.example.tecnobank.intro.data.local.SharedPreferenceServices

class OnBoardingRepository(private val sharedPreferenceServices: SharedPreferenceServices) {

    fun saveUserPassOnboarding() = sharedPreferenceServices.saveUserPassOnboarding()

}
