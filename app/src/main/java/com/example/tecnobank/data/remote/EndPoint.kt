package com.example.tecnobank.data.remote

import com.example.tecnobank.data.remote.model.extract.ExtractResponse
import com.example.tecnobank.data.remote.model.home.BalanceBenefitsResponse
import com.example.tecnobank.data.remote.model.login.LoginPayload
import com.example.tecnobank.data.remote.model.login.LoginResponse
import com.example.tecnobank.data.remote.model.pix.PixItensRequest
import com.example.tecnobank.data.remote.model.pix.PixResponseValidation
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface EndPoint {

    @POST("login")
    suspend fun login(@Body loginPayload: LoginPayload): Response<LoginResponse>

    @GET("home")
    suspend fun BalancesAndBenefits(
        @Header("token") token: String
    ): Response<BalanceBenefitsResponse>

    @GET("extract")
    suspend fun extractTransactions(
        @Query("start") dateFilterStart: String,
        @Query("end") dateFilterEnd: String,
        @Header("token") token: String
    ): Response<List<ExtractResponse>>

    @POST("pix/validation")
    suspend fun pixValidation(
        @Body pixItensRequest: PixItensRequest,
        @Header("token") token: String
    ): Response<PixResponseValidation>

    companion object {

        fun getEndPointInstance(): EndPoint {
            return Retrofit.Builder()
                .baseUrl("https://us-central1-programa-de-bolsas---puc-2021.cloudfunctions.net/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(EndPoint::class.java)
        }

    }
}
