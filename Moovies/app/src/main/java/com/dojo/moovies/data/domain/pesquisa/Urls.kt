package com.dojo.moovies.data.domain.pesquisa

import com.dojo.moovies.api.network.search.response.UrlsResponseBody
import java.io.Serializable

data class Urls(

    val standard_web: String?
) : Serializable {

}