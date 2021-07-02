package com.example.tecnobank.intro.repository

import android.content.SharedPreferences
import com.example.tecnobank.intro.data.local.SharedPreferenceServices
import com.example.tecnobank.intro.data.remote.EndPoint
import com.example.tecnobank.intro.data.remote.model.login.LoginPayload
import com.example.tecnobank.intro.data.remote.model.login.LoginResponse

class LoginRepository(private val endPoint: EndPoint, private val preferences: SharedPreferences) {

    suspend fun login(email: String, password: String): LoginResponse {

        val response = endPoint.login(LoginPayload(email, password))
        if (response.isSuccessful) {
            return response.body()!!
        } else if (response.code() == 401) {
            throw Exception("E-mail ou senha inválida.")
        } else if (response.code() == 404) {
            throw Exception("E-mail não encontrado")
        } else {
            throw Exception("Falha no sistema.")
        }
    }

    fun saveUserLogin(email: String, password: String) =
        SharedPreferenceServices(preferences).saveUserLoginServices(email, password)

    fun deleteUserLogin() = SharedPreferenceServices(preferences).deleteUserLoginServices()

    fun getUserEmail(): String? = SharedPreferenceServices(preferences).getUserEmailServices()

    fun getUserPassword(): String? = SharedPreferenceServices(preferences).getUserPasswordServices()

}
