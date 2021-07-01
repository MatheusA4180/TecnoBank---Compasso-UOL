package com.example.tecnobank.home.model

class BalanceBenefits(
    val balance: Balance,
    val benefits: List<Benefits>
) {
    data class Balance(
        val current_value: String,
        val receivables: String
    )
    data class Benefits(
        val indicator_color: String,
        val image: String,
        val title: String,
        val message: String,
        val text_link: String
    )
}