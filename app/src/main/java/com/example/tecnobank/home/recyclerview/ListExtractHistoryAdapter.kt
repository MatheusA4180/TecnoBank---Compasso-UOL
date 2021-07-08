package com.example.tecnobank.home.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tecnobank.R

class ListExtractHistoryAdapter() :
    RecyclerView.Adapter<ListExtractHistoryAdapter.ExtractViewHolder>() {

    override fun getItemCount(): Int = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExtractViewHolder {
        return ExtractViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.extract_cardview, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ExtractViewHolder, position: Int) {

    }

    class ExtractViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}