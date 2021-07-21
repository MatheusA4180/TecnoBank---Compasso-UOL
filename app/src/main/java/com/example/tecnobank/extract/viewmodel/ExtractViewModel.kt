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

    private val _responseEveryButton = MutableLiveData<List<ExtractItemAdapter>>()
    val responseEveryButton: LiveData<List<ExtractItemAdapter>> = _responseEveryButton

    private val _responseInputButton = MutableLiveData<List<ExtractItemAdapter>>()
    val responseInputButton: LiveData<List<ExtractItemAdapter>> = _responseInputButton

    private val _responseExitButton = MutableLiveData<List<ExtractItemAdapter>>()
    val responseExitButton: LiveData<List<ExtractItemAdapter>> = _responseExitButton

    private val _dataFilter = MutableLiveData<String>()
    val dataFilter: LiveData<String> = _dataFilter

    fun requestExtracts() {
        viewModelScope.launch {
            try {
                receivedListApi = extractRepository.extractTransactions(
                    dateFilterStart,
                    dateFilterEnd
                )

                _loading.postValue(true)

            } catch (e: Exception) {
                _responseErro.postValue(e.message)
                _loading.postValue(true)
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
        _responseEveryButton.postValue(mapItemsForAdapter(cloneListReturnedApi))
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
        _responseInputButton.postValue(mapItemsForAdapter(formattedList))
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
        _responseExitButton.postValue(mapItemsForAdapter(formattedList))
    }

    open class ExtractItemAdapter

    data class ExtractItemHeader(val date: String) : ExtractItemAdapter()

    data class ExtractItemBody(val body: ExtractResponse) : ExtractItemAdapter()

}
