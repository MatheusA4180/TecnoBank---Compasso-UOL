package com.example.tecnobank.intro.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecnobank.intro.repository.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _teste = MutableLiveData<Int>()
    val teste: LiveData<Int> = _teste

    fun onLoginClicked(email:String,senha:String){
        viewModelScope.launch {
            try{
                val loginResponse = loginRepository.login(email, senha)
                _teste.postValue(1)
                //Tratar fluxo sucesso!
            }
            catch (e:Exception){
                //tratar fluxo de erro!
            }
        }
    }
}