package com.dojo.moovies.data.domain.pesquisa

import java.io.Serializable

data class Item(

    val jw_entity_id: String?,
    val id: Int?,
    val title: String?,
    val full_path: String,
    val full_paths: LinkApiCompleto,
    val poster: String?,
    val poster_blur_hash: String?,
    val original_release_year: Int?,
    val object_type: String?,
    val offers: List<Offers>?,
    val scoring: List<Scoring>?


) : Serializable {
    /*
    constructor(movieSearch: MovieSearchResponseBody) : this(
        jw_entity_id = movieSearch.jw_entity_id,
        id = movieSearch.id,
        title = movieSearch.title,
        full_path = movieSearch.full_path,
        full_paths = movieSearch.full_paths?.let { LinkApiCompleto(it) },
        poster = movieSearch.poster,
        poster_blur_hash = movieSearch.poster_blur_hash,
        original_release_year = movieSearch.original_release_year,
        object_type = movieSearch.object_type,
        offers = null,
        scoring = null,
    )

*/
}
