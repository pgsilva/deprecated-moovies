package com.dojo.moovies.api.network

import com.dojo.moovies.api.network.search.PesquisaShowService
import retrofit2.Retrofit

class JustWatchApi(
    private val retrofit: Retrofit
) {

    fun pesquisaShowService() : PesquisaShowService = retrofit.create(PesquisaShowService::class.java)
}