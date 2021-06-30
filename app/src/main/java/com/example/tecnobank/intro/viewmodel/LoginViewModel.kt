package com.example.tecnobank.intro.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecnobank.intro.repository.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    fun onLoginClicked() {
        viewModelScope.launch {
            try{
                val loginResponse = loginRepository.login("", "")
                //Tratar fluxo sucesso!
            }
            catch (e:Exception)
            {
                //tratar fluxo de erro!
            }

        }



    }

}