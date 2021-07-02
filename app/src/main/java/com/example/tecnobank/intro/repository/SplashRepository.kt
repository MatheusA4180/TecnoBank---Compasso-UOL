package com.example.tecnobank.intro.repository

import android.content.SharedPreferences
import com.example.tecnobank.intro.data.local.SharedPreferenceServices

class SplashRepository(private val preferences: SharedPreferences) {

    fun passed():Boolean = SharedPreferenceServices(preferences).passedServices()

}
