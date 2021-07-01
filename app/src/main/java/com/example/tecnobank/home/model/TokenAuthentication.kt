package com.example.tecnobank.home.model

import com.google.gson.annotations.SerializedName

data class TokenAuthentication(
    @SerializedName ("token") val token: String
)