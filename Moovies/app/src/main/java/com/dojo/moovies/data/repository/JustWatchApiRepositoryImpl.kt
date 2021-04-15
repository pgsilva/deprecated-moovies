package com.dojo.moovies.data.repository

import com.dojo.moovies.api.mapper.MovieSearchMapper
import com.dojo.moovies.api.network.JustWatchApi
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
            MovieSearchMapper.responseToDomain(body.items)
        } else {
            null
        }
    }
}