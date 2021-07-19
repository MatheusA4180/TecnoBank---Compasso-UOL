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

    fun onChangeDataFilter(filter: String) {
        this.filter = filter
    }

    fun valueFilter(): String {
        return "nos $filter"
    }

    private val _extractItemAdapter = MutableLiveData<List<ExtractItemAdapter>>()
    val extractItemAdapter: LiveData<List<ExtractItemAdapter>> = _extractItemAdapter

    private val _responseErro = MutableLiveData<String>()
    val responseErro: LiveData<String> = _responseErro

    fun requestExtracts() {
        viewModelScope.launch {
            try {
                val response = extractRepository.extractTransactions(
                    dataFilterStart,
                    dataFilterEnd
                )

                _extractItemAdapter.postValue(mapItemsForAdapter(response))

            } catch (e: Exception) {
                _responseErro.postValue(e.message)
            }
        }
    }

    private fun mapItemsForAdapter(extractList: List<ExtractResponse>): List<ExtractItemAdapter> {
        val formattedList: MutableList<ExtractItemAdapter> = mutableListOf()

        for (i in 0 until extractList.size) {
            if (i == 0) {
                val header = ExtractItemHeader(extractList.get(i).date)
                val body = ExtractItemBody(extractList.get(i).value)
                formattedList.add(header)
                formattedList.add(body)
            } else if (extractList.get(i).date != extractList.get(i - 1).date) {
                val header = ExtractItemHeader(extractList.get(i).date)
                val body = ExtractItemBody(extractList.get(i).value)
                formattedList.add(header)
                formattedList.add(body)
            } else {
                val body = ExtractItemBody(extractList.get(i).value)
                formattedList.add(body)
            }
        }

        return formattedList
    }

    open class ExtractItemAdapter

    data class ExtractItemHeader(val date: String) : ExtractItemAdapter()

    data class ExtractItemBody(val transactionValue: String) : ExtractItemAdapter()

}
