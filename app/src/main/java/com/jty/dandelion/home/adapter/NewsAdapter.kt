package com.jty.dandelion.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jty.dandelion.R
import com.jty.dandelion.customview.CircleImageView

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inFlater = LayoutInflater.from(parent.context)
        var view = inFlater.inflate(R.layout.item_news_rl,parent,false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {

    }

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val news_rl_civ = itemView.findViewById<CircleImageView>(R.id.news_rl_civ)
        val item_title = itemView.findViewById<TextView>(R.id.item_title)
        val item_message = itemView.findViewById<TextView>(R.id.item_message)
        val news_rl_time = itemView.findViewById<TextView>(R.id.news_rl_time)

    }
}