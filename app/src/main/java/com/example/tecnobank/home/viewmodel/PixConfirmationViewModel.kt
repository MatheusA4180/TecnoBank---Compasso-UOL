package com.example.tecnobank.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecnobank.data.remote.model.pix.PixItensRequest
import com.example.tecnobank.data.remote.model.pix.PixResponseConfirmation
import com.example.tecnobank.data.remote.model.pix.PixResponseValidation
import com.example.tecnobank.home.repository.PixConfirmationRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import kotlin.properties.Delegates

class PixConfirmationViewModel(
    private val pixConfirmationRepository: PixConfirmationRepository
): ViewModel() {

    private lateinit var pixEmail: String
    private lateinit var pixDescription: String
    private var pixValue by Delegates.notNull<Double>()
    private var pixDate: String = SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().time)
    private lateinit var responseValidation: PixResponseValidation
    private lateinit var responseConfirm: PixResponseConfirmation

    private val _pixValidationSucess = MutableLiveData<PixResponseValidation>()
    val pixValidationSucess: LiveData<PixResponseValidation> = _pixValidationSucess

    private val _pixValidationError = MutableLiveData<String>()
    val pixValidationError: LiveData<String> = _pixValidationError

    private val _pixConfirmationSucess = MutableLiveData<PixResponseConfirmation>()
    val pixConfirmationSucess: LiveData<PixResponseConfirmation> = _pixConfirmationSucess

    private val _pixConfirmationError = MutableLiveData<String>()
    val pixConfirmationError: LiveData<String> = _pixConfirmationError

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _validDatePix = MutableLiveData<String>()
    val validDatePix: LiveData<String> = _validDatePix

    fun validationDatePix(calendar: Calendar){
        pixDate = SimpleDateFormat("dd/MM/yyyy").format(calendar.time)
        requestValidationPix()
    }

    fun requestValidationPix(){
        viewModelScope.launch {
            _loading.postValue(true)
            try{
                responseValidation = pixConfirmationRepository.pixValidation(getPixItensRequest())
                _pixValidationSucess.postValue(responseValidation)
                _validDatePix.postValue(pixDate)
            }catch (e:Exception){
                _pixValidationError.postValue(e.message)
            }
            _loading.postValue(false)
        }
    }

    fun onClickConfirmationPix() {
        viewModelScope.launch {
            _loading.postValue(true)
            try{
                responseConfirm = pixConfirmationRepository.pixConfirmation(responseValidation.pixToken)
                _pixConfirmationSucess.postValue(responseConfirm)
            }catch (e:Exception){
                _pixConfirmationError.postValue(e.message)
            }
            _loading.postValue(false)
        }
    }

    private fun getPixItensRequest(): PixItensRequest {
        return PixItensRequest(pixEmail,"email",pixDescription,pixValue,pixDate)
    }

    fun setPixItensRequest(email: String, description: String, value: Double) {
        pixEmail = email
        pixDescription = description
        pixValue = value
    }

}