package com.dojo.moovies.data.domain.pesquisa

import com.dojo.moovies.api.network.search.response.LinkApiCompletoResponseBody
import com.dojo.moovies.api.network.search.response.MovieSearchResponseBody
import java.io.Serializable

data class LinkApiCompleto(

    val mOVIE_DETAIL_OVERVIEW: String?
): Serializable {

}
