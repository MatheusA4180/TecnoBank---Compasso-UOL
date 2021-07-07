package com.example.tecnobank.home.data.remote

import com.example.tecnobank.home.model.BalanceBenefits
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header

interface EndPointHome {

    @GET("home")
    suspend fun saldoeBeneficios(@Header("token") token: String): Response<BalanceBenefits>

    companion object {

        fun getRetrofitInstance() : EndPointHome {
            return Retrofit.Builder()
                .baseUrl("https://us-central1-programa-de-bolsas---puc-2021.cloudfunctions.net/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(EndPointHome::class.java)
        }
    }

}
