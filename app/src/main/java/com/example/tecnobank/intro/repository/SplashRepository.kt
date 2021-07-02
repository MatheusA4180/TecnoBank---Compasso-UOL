package com.example.tecnobank.intro.repository

import android.content.SharedPreferences

class SplashRepository(private val preferences: SharedPreferences) {
    fun passed(): Boolean = preferences.getBoolean(SplashRepository.KEY_PASS, false)

    companion object{
        private const val KEY_PASS = "Passou"
    }
}