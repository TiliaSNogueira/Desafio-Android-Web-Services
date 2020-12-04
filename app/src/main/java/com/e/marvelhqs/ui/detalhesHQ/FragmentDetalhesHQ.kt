package com.e.marvelhqs.ui.detalhesHQ

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.e.marvelhqs.R
import com.e.marvelhqs.Results
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detalhes_h_q.view.*
import java.text.SimpleDateFormat
import java.util.*

class FragmentDetalhesHQ : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detalhes_h_q, container, false)

        val picasso = Picasso.get()

        getImagemFundo(picasso, view)


        val hqDetalhado = getObjetoHQ()


        mostraDetalhesHQ(hqDetalhado, view, picasso)


        expandeImagem(hqDetalhado, view)

        voltaParaListaHQ(view)

        return view
    }


    private fun voltaParaListaHQ(view: View) {
        view.toolbar_frag_detalhes.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_fragmentDetalhesHQ_to_fragmentListaHQs)
        }
    }

    private fun expandeImagem(hqDetalhado: Results, view: View) {
        val bundle = bundleOf("chave" to hqDetalhado)
        view.iv_capahq_fragment_detalhes.setOnClickListener {
            findNavController().navigate(
                R.id.action_fragmentDetalhesHQ_to_fragmentImagemExpandida,
                bundle
            )
        }
    }

    private fun mostraDetalhesHQ(
        hqDetalhado: Results,
        view: View,
        picasso: Picasso
    ) {
        val objetoImagem = hqDetalhado.thumbnail.path
        val extensionObj = hqDetalhado.thumbnail.extension
        val tipoImagemObj = "/portrait_uncanny."
        val uriConcatenadaObj = objetoImagem + tipoImagemObj + extensionObj
        view.tv_titulo_frag_detalhes.text = hqDetalhado.title

        if (hqDetalhado.description == null) {
            view.tv_descricao_frag_detalhes.text = "Description not found."
        } else {
            view.tv_descricao_frag_detalhes.text = hqDetalhado.description
        }



        view.tv_price_frag_detalhes.text = hqDetalhado.prices[0].price.toString()
        view.tv_pages_frag_detalhes.text = hqDetalhado.pageCount.toString()
        //  view.tv_published_frag_detalhes.text = hqDetalhado.dates[0].date.toString()
        picasso.load(uriConcatenadaObj).into(view.iv_capahq_fragment_detalhes)


        val date = SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(hqDetalhado.dates.get(0).date)
        val dataFormatada = SimpleDateFormat("MMM dd, yyyy", Locale.US).format(date)

        view.tv_published_frag_detalhes.text =  dataFormatada

    }


    private fun getObjetoHQ(): Results {
        val hqDetalhado = arguments?.get("chave") as Results
        return hqDetalhado
    }

    private fun getImagemFundo(picasso: Picasso, view: View) {
        picasso.load("http://i.annihil.us/u/prod/marvel/i/mg/3/50/526548a343e4b" + "/landscape_large." + "jpg")
            .into(view.iv_fragment_detalhes)
    }


}