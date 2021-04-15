package com.dojo.moovies.api.network.search

import com.dojo.moovies.api.network.search.response.MovieSearchResult
import com.dojo.moovies.data.domain.pesquisa.Pesquisa
import com.dojo.moovies.util.JustWatchApiData.Companion.API_LOCALE
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface PesquisaShowService {

    @POST("content/titles/$API_LOCALE/popular")
    fun search(
        @Query("language") languageApi: String,
        @Body pesquisa: Pesquisa
    ): Call<MovieSearchResult>
}
