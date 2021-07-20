package com.example.tecnobank.extract.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecnobank.data.remote.model.extract.ExtractResponse
import com.example.tecnobank.extract.fragments.BUTTON_EXITS
import com.example.tecnobank.extract.fragments.BUTTON_INPUTS
import com.example.tecnobank.extract.repository.ExtractRepositoty
import kotlinx.coroutines.launch

class ExtractViewModel(private val extractRepository: ExtractRepositoty) : ViewModel() {

    private var dataFilterStart = "07/07/2021"
    private var dataFilterEnd = "09/07/2021"
    private var filter = "últimos 7 dias"
    private lateinit var receivedListApi: List<ExtractResponse>

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

    private val _loading = MutableLiveData<Unit>()
    val loading: LiveData<Unit> = _loading

    fun requestExtracts() {
        viewModelScope.launch {
            try {
                receivedListApi = extractRepository.extractTransactions(
                    dataFilterStart,
                    dataFilterEnd
                )

                _loading.postValue(Unit)

            } catch (e: Exception) {
                _responseErro.postValue(e.message)
            }
        }
    }

    private fun mapItemsForAdapter(extractList: List<ExtractResponse>): List<ExtractItemAdapter> {
        val formattedList: MutableList<ExtractItemAdapter> = mutableListOf()

        for (i in 0 until extractList.size) {
            if (i == 0) {
                val header = ExtractItemHeader(extractList[i].date)
                val body = ExtractItemBody(extractList[i])
                formattedList.add(header)
                formattedList.add(body)
            } else if (extractList[i].date != extractList[i - 1].date) {
                val header = ExtractItemHeader(extractList[i].date)
                val body = ExtractItemBody(extractList[i])
                formattedList.add(header)
                formattedList.add(body)
            } else {
                val body = ExtractItemBody(extractList[i])
                formattedList.add(body)
            }
        }

        return formattedList
    }

    fun returnListForExtractFiltered(buttonClicked: String): List<ExtractItemAdapter> {

        val cloneListReturnedApi = receivedListApi
        val formattedList: MutableList<ExtractResponse> = mutableListOf()

        if (buttonClicked == BUTTON_INPUTS) {

            for (i in 0 until cloneListReturnedApi.size) {
                if ((cloneListReturnedApi[i].type != "Despesa") && (!cloneListReturnedApi[i].time.contains(
                        "CANCELADA"
                    ))
                ) {
                    formattedList.add(cloneListReturnedApi[i])
                }
            }
            return mapItemsForAdapter(formattedList)

        } else if (buttonClicked == BUTTON_EXITS) {
            for (i in 0 until cloneListReturnedApi.size) {

                if ((cloneListReturnedApi[i].type == "Despesa") && (!cloneListReturnedApi[i].time.contains(
                    "CANCELADA"
                ))) {
                    formattedList.add(cloneListReturnedApi[i])
                }
            }
            return mapItemsForAdapter(formattedList)
        } else {
            return mapItemsForAdapter(cloneListReturnedApi)
        }
    }


    open class ExtractItemAdapter

    data class ExtractItemHeader(val date: String) : ExtractItemAdapter()

    data class ExtractItemBody(val body: ExtractResponse) : ExtractItemAdapter()

}

