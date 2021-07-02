package com.example.tecnobank.intro.viewmodel

import androidx.lifecycle.ViewModel
import com.example.tecnobank.intro.repository.OnBoardingRepository
import com.example.tecnobank.intro.repository.SaveUserRepository

class SaveUserViewModel(private val repository: SaveUserRepository):ViewModel() {

    fun saveLogin(email:String,senha:String){
        repository.saveUserLogin(email,senha)
    }

    fun getEmail():String = repository.getUserEmail().toString()

    fun getPassword():String = repository.getUserPassword().toString()
}