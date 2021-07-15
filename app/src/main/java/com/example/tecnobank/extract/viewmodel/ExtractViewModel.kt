package com.example.tecnobank.extract.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecnobank.data.remote.model.extract.ExtractResponse
import com.example.tecnobank.extract.repository.ExtractRepositoty
import kotlinx.coroutines.launch

class ExtractViewModel(private val extractRepository: ExtractRepositoty) : ViewModel() {

    private var dataFilterStart = "07/07/2021"
    private var dataFilterEnd = "09/07/2021"
    private var filter = "últimos 7 dias"

    fun onChangeDataFilter(filter:String){
        this.filter = filter
    }

    fun valueFilter():String{
        return "nos $filter"
    }

    private val _responseSucess = MutableLiveData<List<ExtractResponse>>()
    val responseSucess: LiveData<List<ExtractResponse>> = _responseSucess

    private val _responseErro = MutableLiveData<String>()
    val responseErro: LiveData<String> = _responseErro

    fun requestExtracts() {
        viewModelScope.launch {
            try {
                _responseSucess.postValue(
                    extractRepository.extractTransactions(
                        dataFilterStart,
                        dataFilterEnd
                    )
//                    getNumberOfDates(extractRepository.extractTransactions(
//                        dataFilterStart,
//                        dataFilterEnd
//                    ))
                )
            } catch (e: Exception) {
                _responseErro.postValue(e.message)
            }
        }
    }

//    private fun getNumberOfDates(listTransactions: List<ExtractResponse>):List<ExtractResponse> {
//        var i = 1
//        while(i<listTransactions.size){
//            if(listTransactions[i].date != listTransactions[i-1].date){
//                listDates.add(listTransactions[i].date)
//                listPositionsChangeDates.add(i)
//            }
//            i++
//        }
//        return listDates.size
//
//    }
//    data class

}
