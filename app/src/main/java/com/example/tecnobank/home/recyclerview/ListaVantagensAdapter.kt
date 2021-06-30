package com.example.tecnobank.home.recyclerview

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.tecnobank.R

class ListaVantagensAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val listadecores:List<String> = listOf("#000000","#000000","#000000","#000000","#000000","#000000")
    val listadetitulos:List<String> =
        listOf("Maquininhas PagSeguro","Titulo 2","Titulo 3","Titulo 4","Titulo 5","Titulo 6")
    val listadedescricoes:List<String> =
        listOf("Venda muito mais em até 18x e receba tudo na hora.Só no PagSeguro PagBank!",
            "Descrição da vantagem 2",
            "Descrição da vantagem 3",
            "Descrição da vantagem 4",
            "Descrição da vantagem 5",
            "Descrição da vantagem 6")


    override fun getItemCount(): Int {
        return 6
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val post =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.vantagens_cardview, parent, false)
        return PostViewHolder(post)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PostViewHolder) {
            holder.banner.setBackgroundColor(Color.parseColor(listadecores[position]))
            holder.titulo.text = listadetitulos[position]
            holder.descricao.text = listadedescricoes[position]
        }
    }

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val banner: View = itemView.findViewById(R.id.banner_colorido)
        val imagem: ImageView = itemView.findViewById(R.id.imagem_vantagens)
        val titulo: TextView = itemView.findViewById(R.id.titulo_vantagens)
        val descricao: TextView = itemView.findViewById(R.id.descricao_vantagens)
    }

}