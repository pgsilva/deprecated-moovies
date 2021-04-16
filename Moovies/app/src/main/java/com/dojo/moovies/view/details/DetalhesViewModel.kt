package com.dojo.moovies.view.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dojo.moovies.data.domain.detalhe.DetalheShow
import com.dojo.moovies.data.repository.JustWatchApiRepositoryImpl
import kotlinx.coroutines.launch

class DetalhesViewModel(
    private val justWatchApiRepositoryImpl: JustWatchApiRepositoryImpl
) : ViewModel() {

    val detalheShow = MutableLiveData<DetalheShow?>()

    fun showDetails(language: String, id: String) {
        viewModelScope.launch {
            detalheShow.value = justWatchApiRepositoryImpl.getShowDetalhe(
                language = language,
                id = id
            )
        }
    }

    fun movieDetails(language: String, id: String) {
        viewModelScope.launch {
            detalheShow.value = justWatchApiRepositoryImpl.getMovieDetalhe(
                language = language,
                id = id
            )
        }
    }

}