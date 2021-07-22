package com.example.tecnobank.extract.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecnobank.data.remote.model.extract.ExtractResponse
import com.example.tecnobank.extension.HelperFunctions.getDateMonthFormat
import com.example.tecnobank.extract.repository.ExtractRepositoty
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class ExtractViewModel(private val extractRepository: ExtractRepositoty) : ViewModel() {

    private lateinit var dateFilterStart: String
    private lateinit var dateFilterEnd: String
    private var filterText = "últimos 7 dias"
    private var filterPosition: Int = 1
    private var listfilterDays: List<Int> = listOf(3, 7, 30, 60, 120)
    private lateinit var receivedListApi: List<ExtractResponse>

    fun onChangeDataFilter(filterText: String, filterPosition: Int) {
        this.filterText = filterText
        this.filterPosition = filterPosition
        requestExtracts()
        _dataFilter.postValue("nos $filterText")
    }

    private fun requestDatesStartAndEnd() {
        this.dateFilterStart = SimpleDateFormat("dd/MM/yyyy").format(
            Calendar.getInstance()
                .apply { add(Calendar.DAY_OF_MONTH, -listfilterDays[filterPosition]) }.time
        )
        this.dateFilterEnd = SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().time)
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
                requestDatesStartAndEnd()
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
