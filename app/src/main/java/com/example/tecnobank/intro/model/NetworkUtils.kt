package com.example.tecnobank.intro.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils {

    companion object {

        fun getRetrofitInstance(path : String) : Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://us-central1-programa-de-bolsas---puc-2021.cloudfunctions.net/pbpuc")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}
