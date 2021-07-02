package com.example.tecnobank.intro.repository

import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.tecnobank.intro.data.local.SharedPreferenceServices

class OnBoardingRepository(private val preferences: SharedPreferences) {

    fun saveUserPassOnboarding() =
        SharedPreferenceServices(preferences).saveUserPassOnboardingServices()

}
