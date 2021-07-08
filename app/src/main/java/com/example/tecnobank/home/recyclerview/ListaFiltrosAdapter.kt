package com.example.tecnobank.home.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tecnobank.R

class ListaFiltrosAdapter(
    private val listItemFilter: List<String>,
    private val selectFilterlistener: SelectFilterlistener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var positionSelected: Int = 1

    override fun getItemCount(): Int {
        return 5
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FilterItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_filter, parent, false)//, selectFilterlistener
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is FilterItemViewHolder) {
            holder.description.text = listItemFilter[position]
            holder.itemView.setOnClickListener {
                positionSelected = position
                notifyDataSetChanged()
                selectFilterlistener.selectedFilterlistener(positionSelected)
            }
            if (position == positionSelected) {
                holder.icon.setImageResource(R.drawable.ic_check)
            } else {
                holder.icon.setImageResource(0)
            }
        }
    }

    class FilterItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val description: TextView = itemView.findViewById(R.id.description_filter)
        val icon: ImageView = itemView.findViewById(R.id.image_check)
    }

    interface SelectFilterlistener {
        fun selectedFilterlistener(position: Int)
    }

}
