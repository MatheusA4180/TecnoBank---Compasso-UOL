package com.example.tecnobank.data.remote

import android.content.SharedPreferences
import com.example.tecnobank.data.local.SharedPreferenceServices
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val sharedPreferences: SharedPreferenceServices):Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        if(sharedPreferences.getSaveTokenAuthentication()!="")
        {
            builder.addHeader("token",sharedPreferences.getSaveTokenAuthentication())
        }

        return chain.proceed(builder.build())
    }
}