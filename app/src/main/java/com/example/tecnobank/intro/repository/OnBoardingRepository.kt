package com.example.tecnobank.intro.repository

import com.example.tecnobank.intro.data.local.SharedPreferenceServices

class OnBoardingRepository(private val SPServices: SharedPreferenceServices) {

    fun saveUserPassOnboarding() = SPServices.saveUserPassOnboardingServices()

}
