package com.example.tecnobank.intro.repository

import com.example.tecnobank.intro.data.local.SharedPreferenceServices
import com.example.tecnobank.intro.data.remote.EndPoint
import com.example.tecnobank.intro.data.remote.model.login.LoginPayload
import com.example.tecnobank.intro.data.remote.model.login.LoginResponse

class LoginRepository(
    private val endPoint: EndPoint,
    private val sharedpreferenceServices: SharedPreferenceServices
) {

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
        sharedpreferenceServices.saveUserLogin(email, password)

    fun deleteUserLogin() = sharedpreferenceServices.deleteUserLogin()

    fun getUserEmail(): String? = sharedpreferenceServices.getUserEmail()

    fun getUserPassword(): String? = sharedpreferenceServices.getUserPassword()

    fun saveTokenAuthentication(tokenAuthentication: String) = sharedpreferenceServices
        .saveTokenAuthentication(tokenAuthentication)

}
