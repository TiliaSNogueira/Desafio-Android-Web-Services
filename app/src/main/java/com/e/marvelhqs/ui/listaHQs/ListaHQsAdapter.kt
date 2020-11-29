package com.e.marvelhqs.ui.listaHQs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.e.marvelhqs.R
import com.e.marvelhqs.Results
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_hq.view.*

class ListaHQsAdapter(val listaHQs: List<Results>) :
    RecyclerView.Adapter<ListaHQsAdapter.HQViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HQViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hq, parent, false)
        return HQViewHolder(view)
    }

    override fun onBindViewHolder(holder: HQViewHolder, position: Int) {
        val hq = listaHQs[position]
        val picasso = Picasso.get()
        val urlBase = "https://gateway.marvel.com/v1/public/characters/1011334/"
        picasso.load(urlBase + )

        holder.imagemCapaHQ.setImageResource()
        holder.numeroHQ.text = hq.issueNumber.toString()
    }

    override fun getItemCount() = listaHQs.size

    inner class HQViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imagemCapaHQ: ImageView = view.iv_item_hq
        val numeroHQ: TextView = view.tv_item_hq


    }
}