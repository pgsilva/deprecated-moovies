package com.dojo.moovies.data.repository

import com.dojo.moovies.data.domain.pesquisa.Item
import com.dojo.moovies.data.domain.pesquisa.Pesquisa
import com.dojo.moovies.data.domain.pesquisa.Resultado

interface JustWatchApiRepository {

    suspend fun getPesquisaDeShows(pesquisa: Pesquisa): ArrayList<Item>?
}