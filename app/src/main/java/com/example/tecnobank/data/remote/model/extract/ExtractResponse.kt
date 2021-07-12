package com.example.tecnobank.data.remote.model.extract

import com.google.gson.annotations.SerializedName

data class ListExtractResponse(val listExtractResponse: List<ExtractResponse>){
    data class ExtractResponse(
        val extractObjectOne:ExtractObjectOne,
        val extractObjecTwo:ExtractObjectTwo
    ){
        data class ExtractObjectOne(
            val status: String,
            val time: String,
            val type: String,
            @SerializedName("type_description") val typeDescription: String,
            val value: String,
            val date: String
        )
        data class ExtractObjectTwo(
            @SerializedName("indicator_icon") val indicator_icon: String,
            val time: String,
            val type: String,
            @SerializedName("type_description") val typeDescription: String,
            val value: String,
            val date: String
        )
    }
}

