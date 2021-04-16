package com.dojo.moovies.data.repository

import com.dojo.moovies.api.network.JustWatchApi
import com.dojo.moovies.data.domain.canais.ServicoStream
import com.dojo.moovies.data.domain.detalhe.DetalheShow
import com.dojo.moovies.data.domain.pesquisa.Item
import com.dojo.moovies.data.domain.pesquisa.Pesquisa
import com.dojo.moovies.util.JustWatchApiData.Companion.API_LOCALE
import retrofit2.awaitResponse

class JustWatchApiRepositoryImpl(
    private val justWatchApi: JustWatchApi
) : JustWatchApiRepository {

    override suspend fun getPesquisaDeShows(pesquisa: Pesquisa): ArrayList<Item>? {
        val service =
            justWatchApi.pesquisaShowService().search(languageApi = API_LOCALE, pesquisa = pesquisa)
                .awaitResponse()
        val body = service.body()
        return if (service.isSuccessful && body != null) {
            body.items
        } else {
            null
        }
    }

    override suspend fun getMovieDetalhe(language: String, id: String): DetalheShow? {
        val service = justWatchApi.detalhesService()
            .getMovieDetails(language = language, id = id)
            .awaitResponse()
        val body = service.body()
        return if (service.isSuccessful && body != null) {
            body
        } else {
            null
        }
    }

    override suspend fun getShowDetalhe(language: String, id: String): DetalheShow? {
        val service = justWatchApi.detalhesService()
            .getShowDetails(language = language, id = id)
            .awaitResponse()
        val body = service.body()
        return if (service.isSuccessful && body != null) {
            body
        } else {
            null
        }
    }

    override suspend fun getServicoStream(): List<ServicoStream>? {
        val service = justWatchApi.servicoStreamService()
            .getProviders()
            .awaitResponse()
        val body = service.body()
        return if (service.isSuccessful && body != null) {
            body
        } else {
            null
        }
    }


}