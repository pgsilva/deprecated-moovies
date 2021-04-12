package com.example.moovies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.dojo.model.Resultado
import com.example.moovies.resource.JustWatchResource


class JustWatchViewModel : ViewModel() {
    private val resource = JustWatchResource

    val resultadoPesquisa: (String, Int?, Int?) -> LiveData<Resultado?> =
        { query, page, page_size ->
            liveData<Resultado?> {
                emit(resource.pesquisarShowsEFilmes(query, page, page_size))
            }
        }


    val populares = liveData<Resultado?> {
        emit(resource.pesquisarShowsEFilmes(null, 1, null))
    }

}