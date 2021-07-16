package com.example.tecnobank.home.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tecnobank.R

class ListLearningInvestmentsPostsAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ListLearningInvestmentsPostsAdapter.PostViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_learning_investment, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return 4
    }

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val text: TextView = itemView.findViewById<TextView>(R.id.text_post)
        val img = itemView.findViewById<ImageView>(R.id.btn_post)
    }

}
