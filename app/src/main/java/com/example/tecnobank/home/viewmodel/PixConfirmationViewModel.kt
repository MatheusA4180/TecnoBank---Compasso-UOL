package com.example.tecnobank.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecnobank.data.remote.model.pix.PixItensRequest
import com.example.tecnobank.data.remote.model.pix.PixResponseValidation
import com.example.tecnobank.home.repository.PixConfirmationRepository
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class PixConfirmationViewModel(
    private val pixConfirmationRepository: PixConfirmationRepository
): ViewModel() {

    private var pixDate: String = "26/07/2021"
    private lateinit var response: PixResponseValidation

    private val _pixConfirmationSucess = MutableLiveData<PixResponseValidation>()
    val pixConfirmationSucess: LiveData<PixResponseValidation> = _pixConfirmationSucess

    private val _pixConfirmationError = MutableLiveData<String>()
    val pixConfirmationError: LiveData<String> = _pixConfirmationError

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _validDatePix = MutableLiveData<String>()
    val validDatePix: LiveData<String> = _validDatePix

    fun validationDatePix(calendar: Calendar){
        val currentDate = Calendar.getInstance()
        if(calendar.get(Calendar.DAY_OF_MONTH) >= currentDate.get(Calendar.DAY_OF_MONTH) &&
            calendar.get(Calendar.MONTH) >= currentDate.get(Calendar.MONTH) &&
            calendar.get(Calendar.YEAR) >= currentDate.get(Calendar.YEAR)){
            pixDate = SimpleDateFormat("dd/MM/yyyy").format(calendar.time)
            _validDatePix.postValue(pixDate)
        }
    }

    fun onClickConfirmationPix() {
        viewModelScope.launch {
            try{
                _loading.postValue(true)
                response = pixConfirmationRepository.pixValidation(getPixItensRequest())
                _pixConfirmationSucess.postValue(response)
                _loading.postValue(false)
            }catch (e:Exception){
                _pixConfirmationError.postValue(e.message)
                _loading.postValue(false)
            }
        }
    }

    private fun getPixItensRequest(): PixItensRequest {
        return PixItensRequest("teste@gmail.com","email","","300.00",pixDate)
    }

}