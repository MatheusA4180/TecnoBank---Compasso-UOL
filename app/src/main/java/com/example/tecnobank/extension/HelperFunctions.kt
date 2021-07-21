package com.example.tecnobank.extension

import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

object HelperFunctions {

    fun converterToReal(value: Double): String {
        return NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
            .format(value)
    }

    fun getDateMonthFormat(date: String): String =
        SimpleDateFormat("dd MMMM", Locale("pt", "BR")).format(
            SimpleDateFormat(
                "dd/MM/yyyy",
                Locale("pt", "BR")
            ).parse(date)
        ).substring(0, 6).toUpperCase()
}
