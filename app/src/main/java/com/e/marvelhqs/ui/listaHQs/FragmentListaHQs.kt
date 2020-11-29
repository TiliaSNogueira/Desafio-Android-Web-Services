package com.e.marvelhqs.ui.listaHQs

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.e.marvelhqs.R
import com.e.marvelhqs.repository.service

class FragmentListaHQs : Fragment() {

    private val viewModel by viewModels<ListaHqsViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return  ListaHqsViewModel(service) as T
            }

        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_lista_h_qs, container, false)


        viewModel.listaComics.observe(viewLifecycleOwner, {
            Log.i("LISTA", it.toString())
        })

        viewModel.getListHQs()





        return view
    }


}