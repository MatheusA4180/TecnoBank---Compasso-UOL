package com.example.tecnobank.home.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.getColor
import androidx.core.view.isVisible
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
            holder.bind(listServices)
            holder.cardServices.setOnClickListener {
                clickedServiceListener.clickServiceListener(position, positionViewPager)
            }
        }
    }

    class CardServicesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val cardDecor: CardView = itemView.findViewById(R.id.card_decor)
        private val icon: ImageView = itemView.findViewById(R.id.icon_services)
        private val title: TextView = itemView.findViewById(R.id.title_service)
        val cardServices: CardView = itemView.findViewById(R.id.services_cardview)

        fun bind(listServices: List<ItemService>) {
            icon.setImageResource(listServices[position].icon)
            cardDecor.isVisible = false
            title.text = listServices[position].title
        }
    }

    data class ItemService(
        val incompletService: Boolean,
        val titleInfo: String?,
        val title: String,
        val icon: Int
    )

    interface ClickedServiceListener {
        fun clickServiceListener(positionRecyclerView: Int, positionViewPager: Int)
    }
}
