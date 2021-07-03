package com.example.tecnobank.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecnobank.home.model.BalanceBenefits
import com.example.tecnobank.home.repository.InicioRepository
import kotlinx.coroutines.launch

class InicioViewModel(private val inicioRepository: InicioRepository):ViewModel() {

    private val _sucesso = MutableLiveData<BalanceBenefits>()
    val sucesso: LiveData<BalanceBenefits> = _sucesso

    private val _erro = MutableLiveData<String>()
    val erro:LiveData<String> = _erro

    fun onOpenHome(){
        viewModelScope.launch {
            try{
                val Response = inicioRepository.saldoeBeneficios(getToken())
                _sucesso.postValue(Response)
            }
            catch (e:Exception){
                _erro.postValue(e.message)
            }
        }
    }

    fun getToken(): String = inicioRepository.getTokenAuthentication().toString()

}
