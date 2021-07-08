package com.example.tecnobank.home.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tecnobank.R

class ListaFiltrosAdapter(
    private val listItemFilter: List<String>//,
    //private val selectFilterlistener: SelectFilterlistener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    //private val listSelectFilter: MutableList<Boolean> = mutableListOf(true, false, false, false, false)

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
            //troca da posição do icone
            holder.description.text = listItemFilter[position]
            holder.itemView.setOnClickListener {
                holder.icon.setImageResource(R.drawable.ic_check)
            }
        }
    }

    class FilterItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val description: TextView = itemView.findViewById(R.id.description_filter)
        val icon: ImageView = itemView.findViewById(R.id.image_check)

//        lateinit var selectFilterlistener: SelectFilterlistener
//        this.selectFilterlistener = SelectFilterlistener
//        itemView.setOnClickListener(this)
//
//        override fun onClick(p0: View?) {
//            SelectFilterlistener.selectedFilterlistener(adapterPosition)
//        }


    }

    interface SelectFilterlistener {
        fun selectedFilterlistener(position: Int)
    }

}
