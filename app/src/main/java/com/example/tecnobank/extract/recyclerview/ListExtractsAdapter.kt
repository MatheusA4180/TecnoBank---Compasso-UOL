package com.example.tecnobank.extract.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tecnobank.R
import com.example.tecnobank.data.remote.model.extract.ExtractResponse

class ListExtractsAdapter(
    private val listExtracts: List<ExtractResponse>,
//    private val listDates: List<String>,
//    private val listPositionsChangeDates: List<String>,
    private val buttonPressed: String
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

//    private fun getNumberOfDates():Int {
//        var i = 1
//        while(i<listExtracts.size){
//            if(listExtracts[i].date != listExtracts[i-1].date){
//                listDates.add(listExtracts[i].date)
//                listPositionsChangeDates.add(i)
//            }
//            i++
//        }
//        return listDates.size
//    }

    override fun getItemCount(): Int = 8//listDates.size + listExtracts.size

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return 0
//        }else if(listExtracts[position].date != listExtracts[position-1].date){
//            return 0
        } else {
            return 1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            1 -> {
                return ExtractViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.extract_cardview, parent, false)
                )
            }
            else -> {
                return HeaderViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.header_extract, parent, false)
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        if (holder is HeaderViewHolder) {
//            holder.headerText.text = listExtracts[position].date
//        } else {
//            //o que for mudar na extractViewHolder
//        }
    }

    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val headerText: TextView = itemView.findViewById(R.id.header_text)
    }

    class ExtractViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

}
