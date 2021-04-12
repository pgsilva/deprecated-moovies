package com.example.moovies.resource

import com.dojo.model.Item
import com.dojo.resource.JustWatchPesquisaResource

object JustWatchResource {
    private val justWatchResource: JustWatchPesquisaResource = JustWatchPesquisaResource()

    fun pesquisarShowsEFilmes(keyword: kotlin.String?, page: kotlin.Int?, page_size: kotlin.Int?) =
        justWatchResource.pesquisarFilmesEShows(keyword, page, page_size)

    fun retornarPosterFilmes(item: Item) = justWatchResource.recuperarUrlPoster(item)
}