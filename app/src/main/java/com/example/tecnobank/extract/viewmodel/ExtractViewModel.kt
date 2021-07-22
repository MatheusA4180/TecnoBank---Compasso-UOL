package com.example.tecnobank.extract.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecnobank.data.remote.model.extract.ExtractResponse
import com.example.tecnobank.extension.HelperFunctions.getDateMonthFormat
import com.example.tecnobank.extract.repository.ExtractRepositoty
import kotlinx.coroutines.launch

class ExtractViewModel(private val extractRepository: ExtractRepositoty) : ViewModel() {

    private var dateFilterStart = "07/07/2021"
    private var dateFilterEnd = "09/07/2021"
    private var filter = "últimos 7 dias"
    private lateinit var receivedListApi: List<ExtractResponse>

    fun onChangeDataFilter(filter: String) {
        this.filter = filter
        _dataFilter.postValue("nos $filter")
    }

    private val _responseErro = MutableLiveData<String>()
    val responseErro: LiveData<String> = _responseErro

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _extractList = MutableLiveData<List<ExtractItemAdapter>>()
    val extractList: LiveData<List<ExtractItemAdapter>> = _extractList

    private val _dataFilter = MutableLiveData<String>()
    val dataFilter: LiveData<String> = _dataFilter

    fun requestExtracts() {
        viewModelScope.launch {
            try {
                _loading.postValue(true)
                receivedListApi = extractRepository.extractTransactions(
                    dateFilterStart,
                    dateFilterEnd
                )
                _loading.postValue(false)

            } catch (e: Exception) {
                _responseErro.postValue(e.message)
                _loading.postValue(false)
            }
        }
    }

    private fun mapItemsForAdapter(extractList: List<ExtractResponse>): List<ExtractItemAdapter> {
        val formattedList: MutableList<ExtractItemAdapter> = mutableListOf()

        for (i in 0 until extractList.size) {
            if ((i == 0) || (extractList[i].date != extractList[i - 1].date)) {
                formattedList.add(ExtractItemHeader(getDateMonthFormat(extractList[i].date)))
                formattedList.add(ExtractItemBody(extractList[i]))
            } else {
                formattedList.add(ExtractItemBody(extractList[i]))
            }
        }

        return formattedList
    }

    fun buttonPressedEvery() {
        val cloneListReturnedApi = receivedListApi
        _extractList.postValue(mapItemsForAdapter(cloneListReturnedApi))
    }

    fun buttonPressedInputs() {
        val cloneListReturnedApi = receivedListApi
        val formattedList: MutableList<ExtractResponse> = mutableListOf()
        for (i in 0 until cloneListReturnedApi.size) {
            if ((cloneListReturnedApi[i].type != "Despesa") &&
                (!cloneListReturnedApi[i].time.contains("CANCELADA"))
            ) {
                formattedList.add(cloneListReturnedApi[i])
            }
        }
        _extractList.postValue(mapItemsForAdapter(formattedList))
    }

    fun buttonPressedExit(){
        val cloneListReturnedApi = receivedListApi
        val formattedList: MutableList<ExtractResponse> = mutableListOf()

        for (i in 0 until cloneListReturnedApi.size) {
            if ((cloneListReturnedApi[i].type == "Despesa") &&
                (!cloneListReturnedApi[i].time.contains("CANCELADA"))
            ) {
                formattedList.add(cloneListReturnedApi[i])
            }
        }
        _extractList.postValue(mapItemsForAdapter(formattedList))
    }

    open class ExtractItemAdapter

    data class ExtractItemHeader(val date: String) : ExtractItemAdapter()

    data class ExtractItemBody(val body: ExtractResponse) : ExtractItemAdapter()

}
