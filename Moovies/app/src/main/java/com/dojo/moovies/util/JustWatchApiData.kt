package com.dojo.moovies.util

import com.dojo.moovies.data.dao.ServicoStreamDao.Companion.getUrlIconeServico
import com.dojo.moovies.data.domain.detalhe.DetalheShow
import com.dojo.moovies.data.domain.pesquisa.Item

class JustWatchApiData {
    companion object {
        const val API_URI = "https://apis.justwatch.com/"
        const val API_LOCALE = "pt_BR"
        const val API_PAGE_SIZE = 30
        const val API_LANGUAGE = "pt"
        const val API_IMAGE_URI = "https://images.justwatch.com"
        const val API_SOCORING_TYPE = "tmdb:score"


        val recuperarUrlPoster: (Item?) -> String = fun(item: Item?): String {
            return "$API_IMAGE_URI${item?.poster?.replace("{profile}", "s718")}/${
                item?.full_path?.split("/")?.last()
            }.webp"
        }

        //images.justwatch.com/backdrop/8580211/s1920/rick-and-morty.webp
        val recuperarUrlDetalhe: (DetalheShow?) -> String = fun(item: DetalheShow?): String {
            return "$API_IMAGE_URI${
                item?.backdrops?.first()?.backdrop_url?.replace(
                    "{profile}",
                    "s1920"
                )
            }/${
                item?.full_path?.split("/")?.last()
            }.webp"
        }


        //images.justwatch.com/icon/207360008/s100
        val recuperarUrlProvider: (Int) -> String =
            fun(id: Int): String {
                val urlIcon = getUrlIconeServico(id)
                return "$API_IMAGE_URI${
                    urlIcon?.replace(
                        "{profile}", "s100"
                    )
                }"
            }
    }
}