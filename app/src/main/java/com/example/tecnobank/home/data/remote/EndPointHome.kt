package com.example.tecnobank.home.data.remote

import com.example.tecnobank.home.model.BalanceBenefits
import com.example.tecnobank.home.model.TokenAuthentication
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET

interface EndPointHome {
    @GET("home")
    //falta headers
    suspend fun saldoeBeneficios(@Body token:TokenAuthentication): Response<BalanceBenefits>

    companion object {

        fun getRetrofitInstance() : EndPointHome {
            return Retrofit.Builder()
                .baseUrl("https://us-central1-programa-de-bolsas---puc-2021.cloudfunctions.net/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(EndPointHome::class.java)
        }
    }

}