package com.example.tecnobank.intro.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecnobank.intro.repository.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _goToHome = MutableLiveData<Unit>()
    val goToHome: LiveData<Unit> = _goToHome

    private val _showErro = MutableLiveData<String>()
    val showErro: LiveData<String> = _showErro

    private val _emailErro = MutableLiveData<Unit>()
    val emailErro: LiveData<Unit> = _emailErro

    private val _passwordErro = MutableLiveData<Unit>()
    val passwordErro: LiveData<Unit> = _passwordErro

    private val _setSwitchToggle = MutableLiveData<Unit>()
    val setSwitchToggle: LiveData<Unit> = _setSwitchToggle

    fun onLoginClicked(email: String, password: String) {
        if (email == "") {
            _emailErro.postValue(Unit)
        } else if (password == "") {
            _passwordErro.postValue(Unit)
        } else {
            viewModelScope.launch {
                try {
                    val response = loginRepository.login(email, password)
                    loginRepository.saveTokenAuthentication(response.tokenAuthentication)
                    _goToHome.postValue(Unit)
                } catch (e: Exception) {
                    _showErro.postValue(e.message)
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

    private fun saveLogin(user: String, password: String) {
        loginRepository.saveUserLogin(user, password)
    }

    private fun deleteLogin() {
        loginRepository.deleteUserLogin()
    }

    fun getEmail(): String = loginRepository.getUserEmail().toString()

    fun getPassword(): String = loginRepository.getUserPassword().toString()

    fun thereIsASavedLogin(email: String = getEmail(), password: String = getPassword()) {
        if ((email != "") || (password != "")) {
            _setSwitchToggle.postValue(Unit)
        }
    }

}
