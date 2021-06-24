package com.example.tecnobank.repository

import android.content.SharedPreferences
import androidx.core.content.edit

private const val CHAVE_LOGADO = "LOGADO"

class LoginRepository(private val preferences: SharedPreferences) {
    fun entrou() = salva(true)

    private fun salva(estado: Boolean) {
        preferences.edit {
            putBoolean(CHAVE_LOGADO, estado)
        }
    }
}