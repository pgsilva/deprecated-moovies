package com.dojo.moovies.util

import com.dojo.moovies.data.domain.pesquisa.Item

class JustWatchApiData {
    companion object {
        const val API_URI = "https://apis.justwatch.com/"
        const val API_LOCALE = "pt_BR"
        const val API_PAGE_SIZE = 30
        const val API_IMAGE_URI = "https://images.justwatch.com"


        val recuperarUrlPoster: (Item?) -> String = fun(item: Item?): String {
            return "$API_IMAGE_URI${item?.poster?.replace("{profile}", "s718")}/${
                item?.full_path?.split("/")?.last()
            }.webp"

        }
    }
}