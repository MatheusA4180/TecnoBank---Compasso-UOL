package com.example.tecnobank.home.repository

import com.example.tecnobank.data.remote.EndPoint
import com.example.tecnobank.data.remote.model.home.TokenFirebase

class HomeActivityRepository(
    private val endPoint: EndPoint
) {

    suspend fun sendToken(tokenFirebase: TokenFirebase): Void {

        val response = endPoint.sendToken(tokenFirebase)

        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception("Erro ao enviar o token.")
        }
    }
}