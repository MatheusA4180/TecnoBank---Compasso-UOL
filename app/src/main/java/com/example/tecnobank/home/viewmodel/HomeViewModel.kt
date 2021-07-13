package com.example.tecnobank.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecnobank.data.remote.model.home.BalanceBenefitsResponse
import com.example.tecnobank.home.repository.HomeRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val homeRepository: HomeRepository):ViewModel() {

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
                _responseSucess.postValue(homeRepository.balancesAndBenefits())
            } catch (e: Exception) {
                _responseErro.postValue(e.message)
            }
        }
    }

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
