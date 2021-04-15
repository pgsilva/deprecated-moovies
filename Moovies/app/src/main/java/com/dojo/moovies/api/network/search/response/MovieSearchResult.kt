package com.dojo.moovies.api.network.search.response

import com.squareup.moshi.Json

data class MovieSearchResult(
    @field:Json(name = "page") val page: Int?,
    @field:Json(name = "page_size") val page_size: Int?,
    @field:Json(name = "total_pages") val total_pages: Int?,
    @field:Json(name = "total_results") val total_results: Int?,
    @field:Json(name = "items") val items: ArrayList<MovieSearchResponseBody>

)