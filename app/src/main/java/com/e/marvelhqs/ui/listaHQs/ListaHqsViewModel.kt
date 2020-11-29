package com.e.marvelhqs.ui.listaHQs

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e.marvelhqs.Results
import com.e.marvelhqs.repository.Service
import com.e.marvelhqs.repository.service
import kotlinx.coroutines.launch

class ListaHqsViewModel(service: Service) : ViewModel() {

    val listaComics = MutableLiveData<List<Results>>()

    fun getListHQs() {
        viewModelScope.launch {
            listaComics.value = service.getLisHQRepo().data.results
        }
    }
}
