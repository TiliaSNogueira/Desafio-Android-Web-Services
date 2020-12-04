package com.e.marvelhqs.ui.listaHQs

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e.marvelhqs.Results
import com.e.marvelhqs.repository.Service
import com.e.marvelhqs.repository.service
import kotlinx.coroutines.launch
import retrofit2.HttpException

class ListaHqsViewModel(service: Service) : ViewModel() {

    val listaComics = MutableLiveData<List<Results>>()

    fun getListHQs(offset: Int) : List<Results>? {

        try {
            viewModelScope.launch {
                listaComics.value = service.getLisHQRepo(offset).data.results
            }

            return listaComics.value


        //ERA PRA ENTRAR NO CATH QUANDO A URL ESTÁ COM ALGUM ERRO DE DIGITAÇÃO, MAS NÃO ESTÁ INDO
        } catch (e: HttpException){
            Log.i("LISTAHQVIEWMODEL", e.message.toString())

            return listaComics.value
        }

    }

}



