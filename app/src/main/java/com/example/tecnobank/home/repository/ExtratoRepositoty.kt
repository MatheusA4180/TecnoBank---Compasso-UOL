package com.example.tecnobank.home.repository

import com.example.tecnobank.home.data.remote.EndPointHome
import com.example.tecnobank.home.model.ExtractResponse
import com.example.tecnobank.intro.data.local.SharedPreferenceServices

class ExtratoRepositoty(
    private val endPointHome: EndPointHome,
    private val sharedPreferenceServices: SharedPreferenceServices
) {

    suspend fun extractTransactions(
        token: String,
        dataFilterStart: String,
        dataFilterEnd: String
    ): ExtractResponse {

        val response = endPointHome.extractTransactions(dataFilterStart, dataFilterEnd, token)

        if (response.isSuccessful) {
            return response.body()!!

        } else {
            throw Exception("Erro no sistema.")
        }
    }

    fun getTokenAuthentication(): String? = sharedPreferenceServices.getSaveTokenAuthentication()


}