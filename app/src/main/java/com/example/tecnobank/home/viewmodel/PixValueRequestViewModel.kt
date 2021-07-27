package com.example.tecnobank.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tecnobank.home.repository.PixValueRequestRepository

class PixValueRequestViewModel(private val pixValueRequestRepository:PixValueRequestRepository): ViewModel() {

    private var pixValue: String = ""

    private val _goToConfirmationPix = MutableLiveData<String>()
    val goToConfirmationPix: LiveData<String> = _goToConfirmationPix

    private val _balanceValue = MutableLiveData<String>()
    val balanceValue: LiveData<String> = _balanceValue

    private val _buttonColor = MutableLiveData<Boolean>()
    val buttonColor: LiveData<Boolean> = _buttonColor

    fun changeValuePix(value: String){
        pixValue = value
        changeButtonColor(value)
    }

    private fun changeButtonColor(text: String){
        if(text.isEmpty()){
            _buttonColor.postValue(false)
        }else{
            _buttonColor.postValue(true)
        }
    }

    fun onClickApplyValuePix(){
        if(pixValue.isNotEmpty()) {
            _goToConfirmationPix.postValue(pixValue)
        }
    }

    fun getSaveBalanceValue(){
        _balanceValue.postValue(pixValueRequestRepository.getSaveBalanceValue())
    }

}