package com.example.tecnobank.home.repository

import com.example.tecnobank.data.remote.model.home.BalanceBenefitsResponse
import com.example.tecnobank.data.local.SharedPreferenceServices
import com.example.tecnobank.data.remote.EndPoint

class HomeRepository(
    private val endPointHome: EndPoint,
    private val sharedPreferenceServices: SharedPreferenceServices
) {
    suspend fun BalancesAndBenefits(): BalanceBenefitsResponse {

        val response = endPointHome.BalancesAndBenefits(
            sharedPreferenceServices.getSaveTokenAuthentication()!!)

        if (response.isSuccessful) {
            return response.body()!!

        } else {
            throw Exception("Erro no sistema.")
        }
    }

}

