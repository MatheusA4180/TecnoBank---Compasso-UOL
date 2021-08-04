package com.example.tecnobank.home.viewmodel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tecnobank.data.remote.model.pix.SingleLiveEvent

class PixInfoDestinationViewModel: ViewModel() {

    private lateinit var pixEmail: String

    private val _goToDescriptionPix = SingleLiveEvent<String>()
    val goToDescriptionPix: LiveData<String> = _goToDescriptionPix

    private val _buttonColor = SingleLiveEvent<Boolean>()
    val buttonColor: LiveData<Boolean> = _buttonColor

    private val _emailErro = SingleLiveEvent<String>()
    val emailErro: LiveData<String> = _emailErro

    fun changeDestinationEmailPix(email: String){
        pixEmail = email
        changeButtonColor()
    }

    private fun changeButtonColor(){
        if(isValidEmail()){
            _buttonColor.postValue(true)
        }else{
            _buttonColor.postValue(false)
        }
    }

    fun onClickApplyInfoDestinationPix(){
        if(isValidEmail()){
            _goToDescriptionPix.postValue(pixEmail)
        }else{
            _emailErro.postValue("O email digitado é invalido")
        }
    }

    private fun isValidEmail() =
        pixEmail.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(pixEmail).matches()
}
