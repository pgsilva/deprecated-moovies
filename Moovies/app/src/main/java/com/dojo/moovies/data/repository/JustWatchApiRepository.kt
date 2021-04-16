package com.dojo.moovies.data.repository

import com.dojo.moovies.data.domain.canais.ServicoStream
import com.dojo.moovies.data.domain.detalhe.DetalheShow
import com.dojo.moovies.data.domain.pesquisa.Item
import com.dojo.moovies.data.domain.pesquisa.Pesquisa
import com.dojo.moovies.data.domain.pesquisa.Resultado

interface JustWatchApiRepository {

    suspend fun getPesquisaDeShows(pesquisa: Pesquisa): ArrayList<Item>?
    suspend fun getMovieDetalhe(language: String, id: String): DetalheShow?
    suspend fun getShowDetalhe(language: String, id: String): DetalheShow?
    suspend fun getServicoStream(): List<ServicoStream>?
}