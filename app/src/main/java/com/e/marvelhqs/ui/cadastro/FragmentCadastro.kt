package com.e.marvelhqs.ui.cadastro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.e.marvelhqs.R
import kotlinx.android.synthetic.main.body_cadastro_white.view.*

class FragmentCadastro : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cadastro, container, false)

        vaiParaListaHQ(view)

        return view
    }

    private fun vaiParaListaHQ(view: View) {
        view.btn_save.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentCadastro_to_fragmentListaHQs)
        }
    }


}