package com.example.tecnobank.intro.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecnobank.intro.data.remote.model.login.LoginResponse
import com.example.tecnobank.intro.repository.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _sucesso = MutableLiveData<LoginResponse>()
    val sucesso: LiveData<LoginResponse> = _sucesso

    private val _erro = MutableLiveData<String>()
    val erro:LiveData<String> = _erro

    fun onLoginClicked(email:String,senha:String){
        viewModelScope.launch {
            try{
                val loginResponse = loginRepository.login(email, senha)
                _sucesso.postValue(loginResponse)

            }
            catch (e:Exception){
                _erro.postValue(e.message)
            }
        }
    }

}