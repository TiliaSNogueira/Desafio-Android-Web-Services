package com.e.marvelhqs.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.e.marvelhqs.R
import kotlinx.android.synthetic.main.body_login_white.view.*

class FragmentLogin : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        vaiParaListaHQ(view)

        vaiParaCadastro(view)


        return view
    }

    private fun vaiParaCadastro(view: View) {
        view.tv_create_account_frag_login.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentLogin_to_fragmentCadastro2)
        }
    }

    private fun vaiParaListaHQ(view: View) {
        view.btn_login.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentLogin_to_fragmentListaHQs)
        }
    }


}