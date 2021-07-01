package com.example.tecnobank.home.repository

import com.example.tecnobank.home.data.remote.EndPointHome
import com.example.tecnobank.home.model.BalanceBenefits
import com.example.tecnobank.home.model.TokenAuthentication

class InicioRepository(val endPointHome: EndPointHome) {
    suspend fun saldoeBeneficios(token:String): BalanceBenefits {

        val response = endPointHome.saldoeBeneficios(TokenAuthentication(token))

        if (response.isSuccessful) {
            return response.body()!!

        } else {
            throw Exception("Erro no sistema.")

        }
    }
}