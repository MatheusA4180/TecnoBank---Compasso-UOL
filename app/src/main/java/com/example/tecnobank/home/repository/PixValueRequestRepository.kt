package com.example.tecnobank.home.repository

import com.example.tecnobank.data.local.SharedPreferenceServices

class PixValueRequestRepository(
    private val sharedPreferenceServices: SharedPreferenceServices
) {

    fun getSaveBalanceValue(): String? = sharedPreferenceServices.getSaveBalanceValue()

}