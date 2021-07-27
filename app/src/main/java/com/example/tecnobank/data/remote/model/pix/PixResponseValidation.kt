package com.example.tecnobank.data.remote.model.pix

import com.example.tecnobank.data.remote.model.login.LoginResponse
import com.google.gson.annotations.SerializedName

data class PixResponseValidation(
    val user: LoginResponse.User,
    val pix: String,
    val description: String,
    val organization: String,
    @SerializedName("pix_value") val pixValue: String,
    @SerializedName("pix_token") val pixToken: String,
    val date: String
)
