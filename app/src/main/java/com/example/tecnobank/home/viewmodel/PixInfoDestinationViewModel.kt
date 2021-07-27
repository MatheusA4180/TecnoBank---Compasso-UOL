package com.example.tecnobank.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PixInfoDestinationViewModel: ViewModel() {

    private var pixEmail: String = ""

    private val _goToDescriptionPix = MutableLiveData<String>()
    val goToDescriptionPix: LiveData<String> = _goToDescriptionPix

    private val _buttonColor = MutableLiveData<Boolean>()
    val buttonColor: LiveData<Boolean> = _buttonColor

    fun changeDestinationEmailPix(email: String){
        pixEmail = email
        changeButtonColor(email)
    }

    private fun changeButtonColor(text: String){
        if(text.isEmpty()){
            _buttonColor.postValue(false)
        }else{
            _buttonColor.postValue(true)
        }
    }

    fun onClickApplyInfoDestinationPix(){
        if(pixEmail.isNotEmpty()){
            _goToDescriptionPix.postValue(pixEmail)
        }
    }
}
