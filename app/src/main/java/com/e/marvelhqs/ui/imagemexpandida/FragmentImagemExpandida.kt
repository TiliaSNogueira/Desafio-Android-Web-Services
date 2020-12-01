package com.e.marvelhqs.ui.imagemexpandida

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
import kotlinx.android.synthetic.main.fragment_imagem_expandida.view.*

class FragmentImagemExpandida : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_imagem_expandida, container, false)


        val picasso = Picasso.get()

        val hqExibido = mostraImagemExpandida(picasso, view)


        voltaParaDetalhesHQ(hqExibido, view)

        return view
    }

    private fun mostraImagemExpandida(
        picasso: Picasso,
        view: View
    ): Results {
        val hqExibido = arguments?.get("chave") as Results

        val hqExibidoPath = hqExibido.thumbnail.path
        val hqExibidoExt = hqExibido.thumbnail.extension
        val tipoImagemHq = "/portrait_incredible."
        val uriConcatenadaObj = hqExibidoPath + tipoImagemHq + hqExibidoExt

        picasso.load(uriConcatenadaObj).into(view.iv_frag_imagem_expandida)
        return hqExibido
    }

    private fun voltaParaDetalhesHQ(hqExibido: Results, view: View) {
        val bundleVolta = bundleOf("chave" to hqExibido)
        view.toolbar_frag_imagem_expandida.setNavigationOnClickListener {
            findNavController().navigate(
                R.id.action_fragmentImagemExpandida_to_fragmentDetalhesHQ,
                bundleVolta
            )
        }
    }


}