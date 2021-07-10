package com.example.tecnobank.extract.repository

import com.example.tecnobank.data.local.SharedPreferenceServices
import com.example.tecnobank.data.remote.EndPoint
import com.example.tecnobank.data.remote.model.extract.ExtractResponse

class ExtractRepositoty(
    private val endPointHome: EndPoint,
    private val sharedPreferenceServices: SharedPreferenceServices
) {

    suspend fun extractTransactions(
        dataFilterStart: String,
        dataFilterEnd: String
    ): ExtractResponse {

        val response = endPointHome.extractTransactions(
            dataFilterStart, dataFilterEnd,
            sharedPreferenceServices.getSaveTokenAuthentication()!!
        )

        if (response.isSuccessful) {
            return response.body()!!

        } else {
            throw Exception("Erro no sistema.")
        }
    }

}