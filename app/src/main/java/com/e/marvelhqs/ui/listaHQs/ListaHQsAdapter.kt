package com.e.marvelhqs.ui.listaHQs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.e.marvelhqs.R
import com.e.marvelhqs.Results
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_hq.view.*
import java.net.URI

class ListaHQsAdapter(val listaHQs: List<Results>) :
    RecyclerView.Adapter<ListaHQsAdapter.HQViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HQViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hq, parent, false)
        return HQViewHolder(view)
    }

    override fun onBindViewHolder(holder: HQViewHolder, position: Int) {
        val hq = listaHQs[position]

        holder.numeroHQ.text = hq.issueNumber.toString()

        val picasso = Picasso.get()
       // val base = hq.thumbnail.path.toString()
       val base = "https://i.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73"
        val extension = hq.thumbnail.extension.toString()
        val tipoImagem = "/portrait_xlarge."

        //  picasso.load(base + tipoImagem + extension).into(holder.imagemCapaHQ)
        val uriConcatenada = base + tipoImagem + extension
       // val uri = uriConcatenada.toUri()
       // holder.imagemCapaHQ.setImageURI(uri)


        picasso.load(uriConcatenada).into(holder.imagemCapaHQ)


        //Picasso.get().load(photoUrl).into(imageView);


        //falta clique

    }


    override fun getItemCount() = listaHQs.size

    inner class HQViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imagemCapaHQ: ImageView = view.iv_item_hq
        val numeroHQ: TextView = view.tv_item_hq


    }
}