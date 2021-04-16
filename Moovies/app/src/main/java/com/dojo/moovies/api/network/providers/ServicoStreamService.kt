package com.dojo.moovies.api.network.providers

import com.dojo.moovies.data.domain.canais.ServicoStream
import com.dojo.moovies.util.JustWatchApiData
import com.dojo.moovies.util.JustWatchApiData.Companion.API_LOCALE
import retrofit2.Call
import retrofit2.http.GET

interface ServicoStreamService {

    @GET("/content/providers/locale/${API_LOCALE}")
    fun getProviders(): Call<List<ServicoStream>>
}