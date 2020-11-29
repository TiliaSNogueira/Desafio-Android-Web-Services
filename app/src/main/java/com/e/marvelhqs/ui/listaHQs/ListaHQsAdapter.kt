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

class ListaHQsAdapter(val listaHQs: List<Results>, val listener: onClickLIstenerHQ) :
    RecyclerView.Adapter<ListaHQsAdapter.HQViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HQViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hq, parent, false)
        return HQViewHolder(view)
    }

    override fun onBindViewHolder(holder: HQViewHolder, position: Int) {
        val hq = listaHQs[position]
        val picasso = Picasso.get()
        val base = hq.thumbnail.path.toString()
        val extension = hq.thumbnail.extension.toString()
        val tipoImagem = "/portrait_uncanny."
        val uriConcatenada = base + tipoImagem + extension

        holder.numeroHQ.text = hq.issueNumber.toString()
        picasso.load(uriConcatenada).into(holder.imagemCapaHQ)

        holder.itemView.setOnClickListener {
            listener.escoheHQClick(position)
        }


    }

    interface onClickLIstenerHQ {
        fun escoheHQClick(position: Int)
    }


    override fun getItemCount() = listaHQs.size

    inner class HQViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imagemCapaHQ: ImageView = view.iv_item_hq
        val numeroHQ: TextView = view.tv_item_hq


    }
}