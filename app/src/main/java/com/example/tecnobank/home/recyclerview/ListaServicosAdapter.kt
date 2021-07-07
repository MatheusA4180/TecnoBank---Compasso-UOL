package com.example.tecnobank.home.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tecnobank.R

class ListaServicosAdapter(
    private val listServices: List<ItemService>,
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return listServices.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CardServicosViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.servicos_cardview, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CardServicosViewHolder) {
            holder.icone.setImageResource(listServices[position].icon)
            holder.titulo.text = listServices[position].title
        }
    }

    class CardServicosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icone: ImageView = itemView.findViewById(R.id.icone_services)
        val titulo: TextView = itemView.findViewById(R.id.title_sevice)
    }

    data class ItemService(val title: String, val icon: Int)
}