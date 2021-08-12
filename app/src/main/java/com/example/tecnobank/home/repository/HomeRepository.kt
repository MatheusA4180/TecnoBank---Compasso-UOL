package com.example.tecnobank.home.repository

import com.example.tecnobank.data.remote.EndPoint
import com.example.tecnobank.data.remote.model.home.BalanceBenefitsResponse

class HomeRepository(
    private val endPoint: EndPoint
) {
    suspend fun BalancesAndBenefits(): BalanceBenefitsResponse {

        val response = endPoint.BalancesAndBenefits()

        if (response.isSuccessful) {
            return response.body()!!

        } else {
            throw Exception("Erro no sistema.")
        }
    }

}
