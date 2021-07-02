package com.example.tecnobank.intro.repository

import android.content.SharedPreferences
import androidx.core.content.edit

class OnBoardingRepository(private val preferences: SharedPreferences) {
    fun saveUserPassOnboarding():Boolean {
        preferences.edit {
            putBoolean(KEY_PASS, true)
        }
        return true
    }

    companion object{
        private const val KEY_PASS = "Passou"
    }

}
