package com.e.marvelhqs.ui.listaHQs

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.e.marvelhqs.R
import com.e.marvelhqs.repository.service
import kotlinx.android.synthetic.main.fragment_lista_h_qs.view.*

class FragmentListaHQs : Fragment(), ListaHQsAdapter.onClickLIstenerHQ {

    var offset = 1
    private lateinit var adapterHQs: ListaHQsAdapter
    private lateinit var layoutManagerHQS: GridLayoutManager

    private val viewModel by viewModels<ListaHqsViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return ListaHqsViewModel(service) as T
            }

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_lista_h_qs, container, false)

        layoutManagerHQS = GridLayoutManager(context, 3)
        view.rv_fragmente_lista_HQs.layoutManager = layoutManagerHQS

        view.rv_fragmente_lista_HQs.setHasFixedSize(true)

        viewModel.listaComics.observe(viewLifecycleOwner, {
            adapterHQs = ListaHQsAdapter(it, this)
            view.rv_fragmente_lista_HQs.adapter = adapterHQs
        })

        viewModel.getListHQs(offset)
        setScrollView(view)


        return view
    }

    override fun escoheHQClick(position: Int) {
        viewModel.listaComics.observe(this, {
            val hqEscolhido = it.get(position)

            val bundle = bundleOf("chave" to hqEscolhido)
            findNavController().navigate(R.id.action_fragmentListaHQs_to_fragmentDetalhesHQ, bundle)

        })
    }


    private fun setScrollView(view: View) {
        view.rv_fragmente_lista_HQs?.run {
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    var itensTotais = adapterHQs?.itemCount
                    val itensVisiveis = layoutManagerHQS?.childCount
                    val itensPassados = layoutManagerHQS?.findFirstVisibleItemPosition()

                    if ((itensVisiveis + itensPassados) == itensTotais) {
                        offset++
                        viewModel.getListHQs(offset)
                    }

                }
            })

        }

    }


}