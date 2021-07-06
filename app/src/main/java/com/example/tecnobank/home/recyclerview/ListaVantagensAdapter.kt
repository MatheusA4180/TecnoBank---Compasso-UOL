package com.example.tecnobank.home.recyclerview

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tecnobank.R
import com.example.tecnobank.home.model.BalanceBenefits
import com.squareup.picasso.Picasso

class ListaVantagensAdapter(
    private val listBenefits: List<BalanceBenefits.Benefits>,
    private val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return 4
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.vantagens_cardview, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PostViewHolder) {
            holder.banner.setBackgroundColor(Color.parseColor(listBenefits[position].indicatorColor))
            Picasso.with(context).load(listBenefits[position].image).into(holder.imagem)
            holder.titulo.text = listBenefits[position].title
            holder.descricao.text = listBenefits[position].message
            holder.link.text = listBenefits[position].textLink
        }
    }

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val banner: View = itemView.findViewById(R.id.banner_colorido)
        val imagem: ImageView = itemView.findViewById(R.id.imagem_vantagens)
        val titulo: TextView = itemView.findViewById(R.id.titulo_vantagens)
        val descricao: TextView = itemView.findViewById(R.id.descricao_vantagens)
        val link: TextView = itemView.findViewById(R.id.link_vantagens)
    }

}
