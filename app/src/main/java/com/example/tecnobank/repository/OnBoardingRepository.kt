package com.example.tecnobank.repository

import android.content.SharedPreferences
import androidx.core.content.edit

class OnBoardingRepository(private val preferences: SharedPreferences) {
    fun entrou() {
        preferences.edit {
            putBoolean(CHAVE_PASS, true)
        }
    }

    fun jaentrou(): Boolean = preferences.getBoolean(CHAVE_PASS, false)

    companion object{
        private const val CHAVE_PASS = "Passou"
    }

}
