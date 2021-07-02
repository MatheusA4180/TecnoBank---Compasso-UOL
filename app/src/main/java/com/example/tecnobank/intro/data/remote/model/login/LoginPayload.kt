package com.example.tecnobank.intro.data.remote.model.login

import com.google.gson.annotations.SerializedName

data class LoginPayload(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)
