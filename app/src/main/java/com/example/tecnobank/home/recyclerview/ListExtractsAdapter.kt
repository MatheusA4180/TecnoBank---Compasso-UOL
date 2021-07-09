package com.example.tecnobank.home.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tecnobank.R
import java.util.*

class ListExtractsAdapter(private val CurrentDate: Date) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val listDatas: List<String> = listOf("09", "10", "11")

    override fun getItemCount(): Int = 9

    override fun getItemViewType(position: Int): Int {
        if ((position == 0) || (position % 3 == 0)) {
            return 0
        } else {
            return 1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            1 -> {
                return ListExtractHistoryAdapter.ExtractViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.extract_cardview, parent, false)
                )
            }
            else -> {
                return ListExtractHistoryHeaderAdapter.HeaderViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.header_extrato, parent, false)
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is HeaderViewHolder) {
            holder.headerText.text = "09 Junh"
        } else {
            //o que for mudar na extractViewHolder
        }
    }

    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val headerText: TextView = itemView.findViewById(R.id.header_text)
    }

    class ExtractViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

}