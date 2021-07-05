package com.example.tecnobank.home.viewmodel

import android.text.method.PasswordTransformationMethod
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecnobank.home.model.BalanceBenefits
import com.example.tecnobank.home.repository.InicioRepository
import kotlinx.coroutines.launch

class InicioViewModel(private val inicioRepository: InicioRepository):ViewModel() {

    private var visibleBalances = true

    private val _visibleOn = MutableLiveData<Unit>()
    val visibleOn: LiveData<Unit> = _visibleOn

    private val _visibleOff = MutableLiveData<Unit>()
    val visibleOff:LiveData<Unit> = _visibleOff

    private val _response = MutableLiveData<BalanceBenefits>()
    val response: LiveData<BalanceBenefits> = _response

    private val _responseErro= MutableLiveData<String>()
    val responseErro:LiveData<String> = _responseErro

    fun onOpenHome(){
        viewModelScope.launch {
            try{
                _response.postValue(inicioRepository.saldoeBeneficios(getToken()))
            }
            catch (e:Exception){
                _responseErro.postValue(e.message)
            }
        }
    }

    fun getToken(): String = inicioRepository.getTokenAuthentication().toString()

    fun checkVisibleBalances(){
        if (visibleBalances == true) {
            _visibleOff.postValue(Unit)
            visibleBalances = false
        } else {
            _visibleOn.postValue(Unit)
            visibleBalances = true
        }
    }

}
