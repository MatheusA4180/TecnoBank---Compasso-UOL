package com.example.tecnobank.intro.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecnobank.intro.repository.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    fun onLoginClicked(email:String,senha:String){
        viewModelScope.launch {
            try{
                val loginResponse = loginRepository.login(email, senha)
                //Tratar fluxo sucesso!
            }
            catch (e:Exception){
                //tratar fluxo de erro!
            }
        }
    }
}