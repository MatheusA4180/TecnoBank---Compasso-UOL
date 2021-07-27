package com.example.tecnobank.data.remote.model.pix

import com.example.tecnobank.data.remote.model.login.LoginResponse
import com.google.gson.annotations.SerializedName

data class PixResponseConfirmation(
    val user: LoginResponse.User,
    val pix: String,
    val description: String,
    val organization: String,
    @SerializedName("pix_value") val pixValue: String,
    val date: String
)