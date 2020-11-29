package com.e.marvelhqs.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.e.marvelhqs.R
import com.e.marvelhqs.Results

class FragmentDetalhesHQ : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detalhes_h_q, container, false)

        val hqDetalhado = arguments?.get("chave") as Results





        return view
    }


}