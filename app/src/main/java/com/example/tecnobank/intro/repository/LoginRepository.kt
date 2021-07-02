package com.example.tecnobank.intro.repository

import android.content.SharedPreferences
import com.example.tecnobank.intro.data.remote.EndPoint
import com.example.tecnobank.intro.data.remote.model.login.LoginPayload
import com.example.tecnobank.intro.data.remote.model.login.LoginResponse
import java.lang.Exception

class LoginRepository(val endPoint: EndPoint) {

    suspend fun login(email:String, password:String): LoginResponse{

        val response = endPoint.login(LoginPayload(email,password))
        if (response.isSuccessful)
        {
            return response.body()!!
        }
        else if(response.code()==401)        {

            throw Exception("E-mail ou senha inválida.")
        }
        else if(response.code()==404)
        {
            throw Exception("E-mail não encontrado")
        }
        else
        {
            throw Exception("Falha no sistema.")
        }
    }

}