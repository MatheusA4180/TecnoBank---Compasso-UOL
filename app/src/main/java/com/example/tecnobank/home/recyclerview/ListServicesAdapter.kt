package com.example.tecnobank.home.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tecnobank.R

class ListServicesAdapter(
    private val listServices: List<ItemService>,
    private val clickedServiceListener: ClickedServiceListener,
    private val positionViewPager: Int
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return listServices.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CardServicesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.services_cardview, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CardServicesViewHolder) {
            holder.icon.setImageResource(listServices[position].icon)
            holder.title.text = listServices[position].title
            holder.itemView.setOnClickListener {
                clickedServiceListener.clickServiceListener(position, positionViewPager)
            }
        }
    }

    class CardServicesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: ImageView = itemView.findViewById(R.id.icon_services)
        val title: TextView = itemView.findViewById(R.id.title_service)
    }

    data class ItemService(val title: String, val icon: Int)

    interface ClickedServiceListener {
        fun clickServiceListener(positionRecyclerView: Int, positionViewPager: Int)
    }

}
