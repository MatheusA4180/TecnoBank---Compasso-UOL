package com.example.tecnobank.home.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tecnobank.R

class ListaFiltrosAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val listItemFilter: List<String> = listOf(
        "Últimos 3 dias",
        "Últimos 7 dias",
        "Últimos 30 dias",
        "Últimos 60 dias",
        "Últimos 120 dias"
    )

    override fun getItemCount(): Int {
        return 5
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FilterItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_filter, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is FilterItemViewHolder) {
            holder.description.text = listItemFilter[position]
            holder.itemView.setOnClickListener {
                holder.icon.setImageResource(R.drawable.ic_check)
            }
        }
    }

    class FilterItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val description: TextView = itemView.findViewById(R.id.description_filter)
        val icon: ImageView = itemView.findViewById(R.id.image_check)
    }

}
