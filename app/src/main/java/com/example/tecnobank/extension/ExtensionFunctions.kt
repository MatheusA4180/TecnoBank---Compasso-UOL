package com.example.tecnobank.extension

class ExtensionFunctions() {
    companion object {
        fun converterStringToReal(string: String): String {
            return string.replace(".", ",")
        }

        fun addDecimalCases(string: String): String {
            return "$string.00".replace(".", ",")
        }
    }

}