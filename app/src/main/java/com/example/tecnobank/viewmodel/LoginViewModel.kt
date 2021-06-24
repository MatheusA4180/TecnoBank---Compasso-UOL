package com.example.tecnobank.viewmodel

import androidx.lifecycle.ViewModel
import com.example.tecnobank.repository.LoginRepository

class LoginViewModel(private val repository: LoginRepository) : ViewModel(){
    fun primeiraVez(){
        repository.entrou()
    }
}