package com.dojo.moovies.api.network

import com.dojo.moovies.api.network.details.DetalhesShowService
import com.dojo.moovies.api.network.providers.ServicoStreamService
import com.dojo.moovies.api.network.search.PesquisaShowService
import retrofit2.Retrofit

class JustWatchApi(
    private val retrofit: Retrofit
) {

    fun pesquisaShowService() : PesquisaShowService = retrofit.create(PesquisaShowService::class.java)
    fun detalhesService() : DetalhesShowService = retrofit.create(DetalhesShowService::class.java)
    fun servicoStreamService(): ServicoStreamService = retrofit.create(ServicoStreamService::class.java)
}