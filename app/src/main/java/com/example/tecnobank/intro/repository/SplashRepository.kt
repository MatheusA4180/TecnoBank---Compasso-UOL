package com.example.tecnobank.intro.repository

import com.example.tecnobank.intro.data.local.SharedPreferenceServices

class SplashRepository(private val SPServices: SharedPreferenceServices) {

    fun passed(): Boolean = SPServices.passedServices()

}
