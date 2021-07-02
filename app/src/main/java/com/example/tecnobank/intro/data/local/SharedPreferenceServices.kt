package com.example.tecnobank.intro.data.local

import android.content.SharedPreferences
import androidx.core.content.edit

class SharedPreferenceServices(private val preferences: SharedPreferences) {

    fun passedServices(): Boolean = preferences.getBoolean(KEY_PASS, false)

    fun saveUserPassOnboardingServices() {
        preferences.edit {
            putBoolean(KEY_PASS, true)
        }
    }

    fun saveUserLoginServices(email:String,password:String) {
        preferences.edit {
            putString(USER, email)
            putString(PASSWORD, password)
        }
    }

    fun deleteUserLoginServices() {
        preferences.edit {
            putString(USER, "")
            putString(PASSWORD, "")
        }
    }

    fun getUserEmailServices():String? = preferences.getString(USER, "")

    fun getUserPasswordServices():String? = preferences.getString(PASSWORD, "")

    companion object {
        private const val KEY_PASS = "Passou"
        private const val USER = "Username"
        private const val PASSWORD = "Password"
    }
}
