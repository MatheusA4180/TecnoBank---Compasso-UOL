package com.example.tecnobank.intro.repository

import android.content.SharedPreferences
import android.provider.Telephony.Carriers.PASSWORD
import androidx.core.content.edit

class SaveUserRepository(private val preferences: SharedPreferences) {

    companion object{
        private const val USER = "Username"
        private const val PASSWORD = "Password"

    }

    fun saveUserLogin(email:String,password:String) {
        preferences.edit {
            putString(SaveUserRepository.USER, email)
            putString(SaveUserRepository.PASSWORD, password)
        }
    }

    fun getUserEmail():String? = preferences.getString(SaveUserRepository.USER, "")

    fun getUserPassword():String? = preferences.getString(SaveUserRepository.USER, "")


}