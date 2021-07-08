package com.example.tecnobank.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecnobank.home.model.ExtractResponse
import com.example.tecnobank.home.repository.ExtratoRepositoty
import kotlinx.coroutines.launch

class ExtratoViewModel(private val extratoRepository: ExtratoRepositoty) : ViewModel() {

    private val _responseSucess = MutableLiveData<ExtractResponse>()
    val responseSucess: LiveData<ExtractResponse> = _responseSucess

    private val _responseErro = MutableLiveData<String>()
    val responseErro: LiveData<String> = _responseErro

    fun onOpenExtract(dataFilterStart: String, dataFilterEnd: String) {
        viewModelScope.launch {
            try {
                _responseSucess.postValue(
                    extratoRepository.extractTransactions(
                        getToken(),
                        dataFilterStart,
                        dataFilterEnd
                    )
                )
            } catch (e: Exception) {
                _responseErro.postValue(e.message)
            }
        }
    }

    fun getToken(): String = extratoRepository.getTokenAuthentication().toString()

}