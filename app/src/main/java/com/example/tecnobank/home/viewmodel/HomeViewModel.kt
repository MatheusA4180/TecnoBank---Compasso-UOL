package com.example.tecnobank.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecnobank.data.remote.model.home.BalanceBenefitsResponse
import com.example.tecnobank.extension.HelperFunctions
import com.example.tecnobank.home.repository.HomeRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    private val _balanceVisible = MutableLiveData<Boolean>()
    val balanceVisible: LiveData<Boolean> = _balanceVisible

    private val _responseSucess = MutableLiveData<BalanceBenefitsResponse>()
    val responseSucess: LiveData<BalanceBenefitsResponse> = _responseSucess

    private val _responseErro = MutableLiveData<String>()
    val responseErro: LiveData<String> = _responseErro

    fun onOpenHome() {
        viewModelScope.launch {
            try {
                val response = homeRepository.BalancesAndBenefits()
                _responseSucess.postValue(response)
            } catch (e: Exception) {
                _responseErro.postValue(e.message)
            }
        }
    }

    fun checkVisibleBalances(){
        if (balanceVisible.value == true) {
            _balanceVisible.postValue(false)
        } else {
            _balanceVisible.postValue(true)
        }
    }
}
