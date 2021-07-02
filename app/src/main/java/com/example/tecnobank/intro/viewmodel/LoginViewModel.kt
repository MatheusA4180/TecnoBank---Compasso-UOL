package com.example.tecnobank.intro.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecnobank.intro.repository.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _sucesso = MutableLiveData<Unit>()
    val sucesso: LiveData<Unit> = _sucesso

    private val _erro = MutableLiveData<String>()
    val erro: LiveData<String> = _erro

    private val _emptyFields = MutableLiveData<Unit>()
    val emptyFields: LiveData<Unit> = _emptyFields

    fun onLoginClicked(email: String, password: String) {
        if((email == "")||(password == "")){
            _erro.postValue("O email ou a senha não estão completos")
        }else{
            viewModelScope.launch {
                try {
                    loginRepository.login(email, password)
                    _sucesso.postValue(Unit)

                } catch (e: Exception) {
                    _erro.postValue(e.message)
                }
            }
        }
    }

    fun onSwitchChecked(user: String, password: String) {
        saveLogin(user, password)
    }

    fun offSwitchChecked() {
        deleteLogin()
    }

    fun saveLogin(user: String, password: String) {
        loginRepository.saveUserLogin(user, password)
    }

    fun deleteLogin() {
        loginRepository.deleteUserLogin()
    }

    fun getEmail(): String = loginRepository.getUserEmail().toString()

    fun getPassword(): String = loginRepository.getUserPassword().toString()

    fun initEmptyFields(email: String,password: String){
        if((email != "")||(password != "")){
            _emptyFields.postValue(Unit)
        }
    }

}
