package com.example.tecnobank.intro.data.remote

import com.example.tecnobank.intro.data.remote.model.login.LoginPayload
import com.example.tecnobank.intro.data.remote.model.login.LoginResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface EndPoint {
    @POST("login")
    suspend fun login(@Body loginPayload: LoginPayload): Response<LoginResponse>

    companion object {

        fun getRetrofitInstance() : EndPoint {
            return Retrofit.Builder()
                .baseUrl("https://us-central1-programa-de-bolsas---puc-2021.cloudfunctions.net/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(EndPoint::class.java)
        }
    }

}