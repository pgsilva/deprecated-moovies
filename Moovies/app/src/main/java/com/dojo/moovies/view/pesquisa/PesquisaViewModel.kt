package com.dojo.moovies.view.pesquisa

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.dojo.moovies.data.domain.canais.ServicoStream
import com.dojo.moovies.data.domain.pesquisa.Item
import com.dojo.moovies.data.domain.pesquisa.Pesquisa
import com.dojo.moovies.data.domain.pesquisa.Resultado
import com.dojo.moovies.data.repository.JustWatchApiRepositoryImpl
import kotlinx.coroutines.launch

class PesquisaViewModel(
    private val justWatchApiRepositoryImpl: JustWatchApiRepositoryImpl
) : ViewModel() {

    val listSearch = MutableLiveData<ArrayList<Item>?>()

    fun search(pesquisa: Pesquisa) {
        viewModelScope.launch {
            listSearch.value = justWatchApiRepositoryImpl.getPesquisaDeShows(pesquisa)
        }
    }

    val provider = liveData<List<ServicoStream>> {
        justWatchApiRepositoryImpl.getServicoStream()?.let {
            emit(it)
        }
    }


}