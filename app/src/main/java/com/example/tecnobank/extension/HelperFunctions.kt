package com.example.tecnobank.extension

import java.text.NumberFormat
import java.util.*

object HelperFunctions {

    fun converterToReal(value: Double): String {
        return NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
            .format(value)
    }

    fun getDateMonthFormat(date: String): String {
        return when {
            date.contains("01/20") -> {
                "${date.subSequence(0,2)} JAN"
            }
            date.contains("02/20") -> {
                "${date.subSequence(0,2)} Fev"
            }
            date.contains("03/20") -> {
                "${date.subSequence(0,2)} Mar"
            }
            date.contains("04/20") -> {
                "${date.subSequence(0,2)} Abr"
            }
            date.contains("05/20") -> {
                "${date.subSequence(0,2)} Mai"
            }
            date.contains("06/20") -> {
                "${date.subSequence(0,2)} Jun"
            }
            date.contains("07/20") -> {
                "${date.subSequence(0,2)} Jul"
            }
            date.contains("08/20") -> {
                "${date.subSequence(0,2)} Ago"
            }
            date.contains("09/20") -> {
                "${date.subSequence(0,2)} Set"
            }
            date.contains("10/20") -> {
                "${date.subSequence(0,2)} Out"
            }
            date.contains("11/20") -> {
                "${date.subSequence(0,2)} Nov"
            }
            date.contains("12/20") -> {
                "${date.subSequence(0,2)} Dez"
            }
            else -> {
                throw Exception("Data não encontrada")
            }
        }
    }

}
