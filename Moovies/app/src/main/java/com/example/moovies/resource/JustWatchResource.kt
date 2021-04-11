package com.example.moovies.resource

import com.dojo.model.Item
import com.dojo.resource.JustWatchPesquisaResource

object JustWatchResource {
    private val justWatchResource: JustWatchPesquisaResource = JustWatchPesquisaResource()

    fun pesquisarShowsEFilmes(query: String?) = justWatchResource.pesquisarFilmesEShows(query)

    fun retornarPosterFilmes(item: Item) = justWatchResource.recuperarUrlPoster(item)
}