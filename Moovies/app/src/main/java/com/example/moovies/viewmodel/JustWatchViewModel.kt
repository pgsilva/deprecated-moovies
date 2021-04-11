package com.example.moovies.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.dojo.model.Resultado
import com.example.moovies.resource.JustWatchResource

class JustWatchViewModel : ViewModel() {
    private val resource = JustWatchResource

    val resultado = liveData<Resultado?> {
        emit(resource.pesquisarShowsEFilmes("the Office"))
    }

    val populares = liveData<Resultado?> {
        emit(resource.pesquisarShowsEFilmes(null))
    }

}