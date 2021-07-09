package com.example.tecnobank.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecnobank.home.model.BalanceBenefitsResponse
import com.example.tecnobank.home.repository.InicioRepository
import kotlinx.coroutines.launch

class InicioViewModel(private val inicioRepository: InicioRepository):ViewModel() {

    private var visibleBalances = true

    private val _visibleBalancesOn = MutableLiveData<Unit>()
    val visibleBalancesOn: LiveData<Unit> = _visibleBalancesOn

    private val _visibleBalancesOff = MutableLiveData<Unit>()
    val visibleBalancesOff: LiveData<Unit> = _visibleBalancesOff

    private val _responseSucess = MutableLiveData<BalanceBenefitsResponse>()
    val responseSucess: LiveData<BalanceBenefitsResponse> = _responseSucess

    private val _responseErro = MutableLiveData<String>()
    val responseErro: LiveData<String> = _responseErro

    fun onOpenHome() {
        viewModelScope.launch {
            try {
                _responseSucess.postValue(inicioRepository.BalancesAndBenefits(getToken()))
            } catch (e: Exception) {
                _responseErro.postValue(e.message)
            }
        }
    }

    fun getToken(): String = inicioRepository.getTokenAuthentication().toString()

    fun checkVisibleBalances(){
        if (visibleBalances == true) {
            _visibleBalancesOff.postValue(Unit)
            visibleBalances = false
        } else {
            _visibleBalancesOn.postValue(Unit)
            visibleBalances = true
        }
    }

}
