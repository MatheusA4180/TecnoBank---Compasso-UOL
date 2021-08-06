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

    private val _balanceValue = MutableLiveData<String>()
    val balanceValue: LiveData<String> = _balanceValue

    private val _confirmationButtonEnabled = MutableLiveData<Boolean>()
    val confirmationButtonEnabled: LiveData<Boolean> = _confirmationButtonEnabled

    private val _balanceVisible = MutableLiveData<Boolean>()
    val balanceVisible: LiveData<Boolean> = _balanceVisible

    private val _invalidValueError = SingleLiveEvent<String>()
    val invalidValueError: SingleLiveEvent<String> = _invalidValueError

    fun changeValuePix(value: String){
        pixValue = parseRealForString(value)
        changeButtonColor()
    }

    private fun changeButtonColor(){
        _confirmationButtonEnabled.postValue(pixValue.isNotEmpty())
    }

    fun onClickApplyValuePix(){
        if (pixValue.isNotEmpty() && (pixValue.toDouble() > 0 && pixValue.toDouble() < parseRealForString(
                pixValueRequestRepository.getSaveBalanceValue()!!).toDouble())
        ) {
            _goToConfirmationPix.postValue(pixValue)
        } else {
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

    fun onOcultBalanceClicked(){
        _balanceVisible.postValue(!(balanceVisible.value == true))
    }
}
