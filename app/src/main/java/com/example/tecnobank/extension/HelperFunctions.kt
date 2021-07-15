package com.example.tecnobank.extension

import java.text.NumberFormat
import java.util.*

object HelperFunctions {

    fun converterToReal(value: Double): String {
        return NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
            .format(value)
    }
}
