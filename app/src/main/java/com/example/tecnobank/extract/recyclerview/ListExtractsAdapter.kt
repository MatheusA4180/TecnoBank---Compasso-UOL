package com.example.tecnobank.extract.recyclerview

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tecnobank.R
import com.example.tecnobank.data.remote.model.extract.ExtractResponse
import com.example.tecnobank.extract.viewmodel.ExtractViewModel

class ListExtractsAdapter(
    private val listExtracts: List<ExtractViewModel.ExtractItemAdapter>
    ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount() = listExtracts.size

    override fun getItemViewType(position: Int): Int {
        val item = listExtracts.get(position)
        if (item is ExtractViewModel.ExtractItemHeader) {
            return LIST_DATE_TYPE
        } else if (item is ExtractViewModel.ExtractItemBody) {
            return LIST_EXTRACT_TYPE
        } else {
            throw Exception("Tipo invalido!")
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            LIST_EXTRACT_TYPE -> {
                return ExtractViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.extract_cardview, parent, false)
                )
            }
            LIST_DATE_TYPE -> {
                return HeaderViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.header_extract, parent, false)
                )
            }
            else -> {
                throw Exception("Tipo nao definido!")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is HeaderViewHolder) {
            val item = listExtracts.get(position) as ExtractViewModel.ExtractItemHeader
            holder.bind(item)
        } else if(holder is ExtractViewHolder) {
            val item = listExtracts.get(position) as ExtractViewModel.ExtractItemBody
            holder.bind(item.body)
        }

    }


     class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val headerText: TextView = itemView.findViewById(R.id.header_text)

        fun bind(item: ExtractViewModel.ExtractItemHeader) {
            headerText.text = item.date.substring(0, 6).toUpperCase()
        }
    }

    class ExtractViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val transactionValue: TextView = itemView.findViewById(R.id.extract_value_transaction)
        private val transactionTime: TextView = itemView.findViewById(R.id.extract_time)
        private val transactionName: TextView = itemView.findViewById(R.id.extract_type)
        private val transactionType: TextView = itemView.findViewById(R.id.extract_type_description)

        fun bind(body: ExtractResponse) {
            transactionValue.text = body.value
            transactionName.text = body.type
            transactionType.text = body.typeDescription
            if (body.type == EXPENSE) {

                transactionValue.setTextColor(Color.RED)
                transactionValue.text = "-${body.value}"
            }
            transactionType.text = body.typeDescription
            transactionTime.text = body.time
        }
    }

    companion object {
        private const val LIST_DATE_TYPE = 0
        private const val LIST_EXTRACT_TYPE = 1
        const val EXPENSE = "Despesa"
        const val CANCELED = "CANCELADA"
    }
}
