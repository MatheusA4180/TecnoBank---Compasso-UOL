package com.example.tecnobank.intro.repository

import com.example.tecnobank.intro.data.local.SharedPreferenceServices
import com.example.tecnobank.intro.data.remote.EndPoint
import com.example.tecnobank.intro.data.remote.model.login.LoginPayload
import com.example.tecnobank.intro.data.remote.model.login.LoginResponse

class LoginRepository(
    private val endPoint: EndPoint,
    private val SPServices: SharedPreferenceServices
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
        SPServices.saveUserLoginServices(email, password)

    fun deleteUserLogin() = SPServices.deleteUserLoginServices()

    fun getUserEmail(): String? = SPServices.getUserEmailServices()

    fun getUserPassword(): String? = SPServices.getUserPasswordServices()

    fun saveTokenAuthentication(tokenAuthentication: String) = SPServices
        .saveTokenAuthenticationServices(tokenAuthentication)

}
