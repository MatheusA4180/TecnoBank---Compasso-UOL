package com.example.tecnobank.home.repository

import com.example.tecnobank.home.data.remote.EndPointHome
import com.example.tecnobank.home.model.BalanceBenefitsResponse
import com.example.tecnobank.intro.data.local.SharedPreferenceServices

class InicioRepository(
    val endPointHome: EndPointHome,
    private val sharedPreferenceServices: SharedPreferenceServices
) {
    suspend fun BalancesAndBenefits(token: String): BalanceBenefitsResponse {

        val response = endPointHome.BalancesAndBenefits(token)

        if (response.isSuccessful) {
            return response.body()!!

        } else {
            throw Exception("Erro no sistema.")
        }
    }

    fun getTokenAuthentication(): String? = sharedPreferenceServices.getSaveTokenAuthentication()

}

