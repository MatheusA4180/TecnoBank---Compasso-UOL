package com.example.tecnobank.extension

import java.text.NumberFormat
import java.util.*

class ExtensionFunctions() {
    companion object{
        fun converterToReal(string: String): String {

            return NumberFormat.getCurrencyInstance(Locale("pt", "BR")).
            format(string.toDouble())
        }
    }

}