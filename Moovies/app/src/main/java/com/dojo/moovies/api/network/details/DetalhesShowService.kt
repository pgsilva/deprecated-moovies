package com.dojo.moovies.api.network.details

import com.dojo.moovies.data.domain.detalhe.DetalheShow
import com.dojo.moovies.util.JustWatchApiData
import com.dojo.moovies.util.JustWatchApiData.Companion.API_LOCALE
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DetalhesShowService {

    @GET("content/titles/movie/{id}/locale/${API_LOCALE}")
    fun getMovieDetails(
        @Path("id") id: String,
        @Query("language") language: String,
    ): Call<DetalheShow>

    @GET("content/titles/show/{id}/locale/${API_LOCALE}")
    fun getShowDetails(
        @Path("id") id: String,
        @Query("language") language: String,
    ): Call<DetalheShow>
}