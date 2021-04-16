package com.dojo.moovies.data.domain.pesquisa

import java.io.Serializable

data class Pesquisa(
    val content_types: List<String>? = null,
    val presentation_types: String? = null,
    val providers: String? = null,
    val genres: String? = null,
    val languages: String? = null,
    val release_year_from: String? = null,
    val release_year_until: String? = null,
    val monetization_types: String? = null,
    val min_price: String? = null,
    val max_price: String? = null,
    val scoring_filter_types: String? = null,
    val cinema_release: String? = null,
    var query: String?,
    val page: Int? = null,
    val page_size: Int? = null

): Serializable