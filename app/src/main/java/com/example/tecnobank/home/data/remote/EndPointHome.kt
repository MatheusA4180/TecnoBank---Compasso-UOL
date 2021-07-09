package com.example.tecnobank.home.data.remote

import com.example.tecnobank.home.model.BalanceBenefitsResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header

interface EndPointHome {

    @GET("home")
    suspend fun BalancesAndBenefits(@Header("token") token: String): Response<BalanceBenefitsResponse>

    companion object {

        fun getEndPointHomeIntance(): EndPointHome {
            return Retrofit.Builder()
                .baseUrl("https://us-central1-programa-de-bolsas---puc-2021.cloudfunctions.net/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(EndPointHome::class.java)
        }
    }

}
