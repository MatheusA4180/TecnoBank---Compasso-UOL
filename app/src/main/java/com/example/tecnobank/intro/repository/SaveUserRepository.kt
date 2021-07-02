package com.example.tecnobank.intro.repository

import android.content.SharedPreferences
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

    fun deleteUserLogin() {
        preferences.edit {
            putString(SaveUserRepository.USER, "")
            putString(SaveUserRepository.PASSWORD, "")
        }
    }

    fun getUserEmail():String? = preferences.getString(SaveUserRepository.USER, "")

    fun getUserPassword():String? = preferences.getString(SaveUserRepository.PASSWORD, "")

}