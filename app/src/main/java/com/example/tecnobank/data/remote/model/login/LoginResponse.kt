package com.example.tecnobank.data.remote.model.login

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    val user: User,
    @SerializedName("token_authentication") val tokenAuthentication: String,
    @SerializedName("refresh_token") val refreshToken: String
) {
    data class User(
        val lastName: String,
        val firstName: String
    )

}
