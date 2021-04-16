package com.dojo.moovies.di

import com.dojo.moovies.api.network.JustWatchApi
import com.dojo.moovies.data.repository.JustWatchApiRepositoryImpl
import com.dojo.moovies.util.JustWatchApiData.Companion.API_URI
import com.dojo.moovies.view.details.DetalhesViewModel
import com.dojo.moovies.view.pesquisa.PesquisaViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

val apiModules = module {
    val retrofit = Retrofit.Builder()
        .baseUrl(API_URI)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    single { JustWatchApi(retrofit = retrofit) }
}

val searchModule = module {
    viewModel {
        PesquisaViewModel(
            JustWatchApiRepositoryImpl(
                justWatchApi = get()
            )
        )
    }
}

val detailsModule = module {
    viewModel {
        DetalhesViewModel(
            JustWatchApiRepositoryImpl(
                justWatchApi = get()
            )
        )
    }
}