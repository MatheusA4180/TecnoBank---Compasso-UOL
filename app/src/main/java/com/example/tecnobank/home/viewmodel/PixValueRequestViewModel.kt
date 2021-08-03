package com.example.tecnobank.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tecnobank.data.remote.model.pix.SingleLiveEvent
import com.example.tecnobank.home.repository.PixValueRequestRepository

class PixValueRequestViewModel(private val pixValueRequestRepository:PixValueRequestRepository): ViewModel() {

    private var pixValue: String = ""

    private val _goToConfirmationPix = SingleLiveEvent<String>()
    val goToConfirmationPix: LiveData<String> = _goToConfirmationPix

    private val _balanceValue = SingleLiveEvent<String>()
    val balanceValue: LiveData<String> = _balanceValue

    private val _buttonColor = MutableLiveData<Boolean>()
    val buttonColor: LiveData<Boolean> = _buttonColor

    private val _balanceVisible = MutableLiveData<Boolean>()
    val balanceVisible: LiveData<Boolean> = _balanceVisible

    private val _invalidValueError = SingleLiveEvent<String>()
    val invalidValueError: SingleLiveEvent<String> = _invalidValueError

    fun changeValuePix(value: String){
        pixValue = parseRealForString(value)
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
        if(pixValue.isNotEmpty() &&
            (pixValue.toDouble() > 0 && pixValue.toDouble() < parseRealForString(pixValueRequestRepository
                .getSaveBalanceValue()!!).toDouble())) {
            _goToConfirmationPix.postValue(pixValue)
        }else{
            _invalidValueError.postValue("Valor inválido!")
        }
    }

    private fun parseRealForString(real: String):String = real
        .replace(".", "")
        .replace(",", ".")
        .substring(3)

    fun getSaveBalanceValue(){
        _balanceValue.postValue(pixValueRequestRepository.getSaveBalanceValue())
    }

    fun checkVisibleBalances(){
        if (balanceVisible.value == true) {
            _balanceVisible.postValue(false)
        } else {
            _balanceVisible.postValue(true)
        }
    }
}