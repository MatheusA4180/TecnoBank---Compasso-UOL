package com.example.tecnobank.home.repository

import com.example.tecnobank.data.local.SharedPreferenceServices
import com.example.tecnobank.data.remote.EndPoint
import com.example.tecnobank.data.remote.model.pix.PixItensRequest
import com.example.tecnobank.data.remote.model.pix.PixResponseConfirmation
import com.example.tecnobank.data.remote.model.pix.PixResponseValidation

class PixConfirmationRepository(
    private val endPoint: EndPoint,
    private val sharedPreferenceServices: SharedPreferenceServices
) {

    suspend fun pixValidation(pixItensRequest: PixItensRequest): PixResponseConfirmation {

        val response = endPoint.pixValidation(
            pixItensRequest,
            sharedPreferenceServices.getSaveTokenAuthentication()!!
        )



        if (response.isSuccessful) {
            val responseConfirmation = endPoint.pixConfirmation(response.body()!!.pixToken,sharedPreferenceServices.getSaveTokenAuthentication()!!)
            if(responseConfirmation.isSuccessful)
            {
                return responseConfirmation.body()!!
            }
            else{
                throw Exception("Erro no sistema.")
            }

        } else {
            throw Exception("Erro no sistema.")
        }
    }

//    suspend fun pixConfirmation(pixToken: String): PixResponseConfirmation{
//        val response = endPoint.pixConfirmation(
//            sharedPreferenceServices.getSaveTokenAuthentication()!!,
//            pixToken
//        )
//
//        if (response.isSuccessful) {
//            return response.body()!!
//
//        } else {
//            throw Exception("Erro no sistema.")
//        }
//    }

}
