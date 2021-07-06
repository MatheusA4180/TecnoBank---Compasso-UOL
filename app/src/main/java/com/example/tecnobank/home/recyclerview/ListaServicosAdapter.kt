package com.example.tecnobank.home.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tecnobank.R

class ListaServicosAdapter(private val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val listServicesTitles: List<String> = listOf(
        "Transferências",
        "Cartões",
        "Pagar Contas",
        "Recargas",
        "Adicionar dinheiro",
        "Pix/QR Code",
        "Aplicando meu Dinheiro",
        "Meus Investimentos",
        "Seguros",
        "Aprenda a Investir",
        "Postos Shell",
        "Radar de Ofertas",
        "Shopping",
        "Onde sacar Dinheiro",
        "Indique e Ganhe",
        "Pagar com QR code"
    )

    val listServicesIcons: List<String> = listOf("ic_transferencia", "ic_cartoes")


    override fun getItemCount(): Int {
        return 16
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val cardService =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.servicos_cardview, parent, false)
        return CardServicosViewHolder(cardService)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CardServicosViewHolder) {
            //holder.icone.setImageDrawable()
            // context.getDrawable(context.resources.getIdentifier(listServicesIcons[position],
            //"drawable",context.getPckageName()
            //)))
            holder.titulo.text = listServicesTitles[position]
        }
    }

    class CardServicosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icone: ImageView = itemView.findViewById(R.id.icone_services)
        val titulo: TextView = itemView.findViewById(R.id.title_sevice)
    }


}