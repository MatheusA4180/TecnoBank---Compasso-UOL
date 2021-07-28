package com.example.tecnobank.extract.repository

import com.example.tecnobank.data.local.SharedPreferenceServices
import com.example.tecnobank.data.remote.EndPoint
import com.example.tecnobank.data.remote.model.extract.ExtractResponse

class ExtractRepositoty(
    private val endPoint: EndPoint,
    private val sharedPreferenceServices: SharedPreferenceServices
) {

    suspend fun extractTransactions(
        dateFilterStart: String,
        dateFilterEnd: String
    ): List<ExtractResponse> {

        val response = endPoint.extractTransactions(
            dateFilterStart, dateFilterEnd,
            sharedPreferenceServices.getSaveTokenAuthentication()!!
        )

        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception("Erro no sistema.")
        }

    }

}
