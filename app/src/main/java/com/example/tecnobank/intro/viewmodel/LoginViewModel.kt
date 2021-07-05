package com.example.tecnobank.intro.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecnobank.intro.repository.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private var email:String? = null
    private var password:String? = null
    private var onChecked:Boolean = false

    private val _goToHome = MutableLiveData<Unit>()
    val goToHome: LiveData<Unit> = _goToHome

    private val _showErro = MutableLiveData<String>()
    val showErro: LiveData<String> = _showErro

    private val _emailErro = MutableLiveData<Unit>()
    val emailErro: LiveData<Unit> = _emailErro

    private val _passwordErro = MutableLiveData<Unit>()
    val passwordErro: LiveData<Unit> = _passwordErro

    private val _rememberUserToogle = MutableLiveData<Unit>()
    val rememberUserToogle: LiveData<Unit> = _rememberUserToogle


    fun onEmailChange(email: String): String {
        this.email = email
        return email
    }

    fun onPasswordChange(password: String): String {
        this.password = password
        return password
    }


    fun onLoginClicked() {
        login()
    }

    private fun login() {
        if (email.isNullOrBlank()) {
            _emailErro.postValue(Unit)
        } else if (password.isNullOrBlank()) {
            _passwordErro.postValue(Unit)
        } else {
            viewModelScope.launch {
                try {
                    val response = loginRepository.login(email!!, password!!)
                    if (onChecked) {
                        saveLogin()
                    }
                    loginRepository.saveTokenAuthentication(response.tokenAuthentication)
                    _goToHome.postValue(Unit)
                } catch (e: Exception) {
                    _showErro.postValue(e.message)
                }
            }
        }
    }

    fun onRememberChecked(isChecked:Boolean) {
        if(isChecked) {
            this.onChecked = true
        }else{
            this.onChecked = false
            deleteLogin()
        }
    }

    private fun saveLogin() {
        loginRepository.saveUserLogin(email!!, password!!)
    }

    private fun deleteLogin() {
        loginRepository.deleteUserLogin()
    }

    fun getEmail(): String = loginRepository.getUserEmail().toString()

    fun getPassword(): String = loginRepository.getUserPassword().toString()

    fun initLogin() {
        if ((email != "") || (password != "")) {
            _rememberUserToogle.postValue(Unit)
        }
    }

}
