package com.e.marvelhqs.ui.detalhesHQ

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.e.marvelhqs.R
import com.e.marvelhqs.Results
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detalhes_h_q.view.*

class FragmentDetalhesHQ : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detalhes_h_q, container, false)

        val picasso = Picasso.get()

        picasso.load( "http://i.annihil.us/u/prod/marvel/i/mg/3/50/526548a343e4b" +"/landscape_large."+"jpg").into(view.iv_fragment_detalhes)


        val hqDetalhado = arguments?.get("chave") as Results


        val objetoImagem = hqDetalhado.thumbnail.path
        val extensionObj = hqDetalhado.thumbnail.extension
        val tipoImagemObj = "/portrait_uncanny."
        val uriConcatenadaObj = objetoImagem + tipoImagemObj + extensionObj

        view.tv_titulo_frag_detalhes.text = hqDetalhado.title
        view.tv_descricao_frag_detalhes.text = hqDetalhado.description
        // view.tv_published_frag_detalhes.text = hqDetalhado.dates.get(1).toString()
        // view.tv_price_frag_detalhes.text = hqDetalhado.prices.get(1).toString()
        view.tv_pages_frag_detalhes.text = hqDetalhado.pageCount.toString()
        picasso.load(uriConcatenadaObj).into(view.iv_capahq_fragment_detalhes)


        val bundle = bundleOf("chave" to hqDetalhado)
        view.iv_capahq_fragment_detalhes.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentDetalhesHQ_to_fragmentImagemExpandida, bundle)
        }

        view.toolbar_frag_detalhes.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_fragmentDetalhesHQ_to_fragmentListaHQs)
        }

        return view
    }


}