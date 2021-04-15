package com.dojo.moovies.api.network.search.response

import com.squareup.moshi.Json

data class MovieSearchResponseBody(
    @field:Json(name = "jw_entity_id") val jw_entity_id: String?,
    @field:Json(name = "id") val id: Int?,
    @field:Json(name = "title") val title: String?,
    @field:Json(name = "full_path") val full_path: String?,
    @field:Json(name = "full_paths") val full_paths: LinkApiCompletoResponseBody?,
    @field:Json(name = "poster") val poster: String?,
    @field:Json(name = "poster_blur_hash") val poster_blur_hash: String?,
    @field:Json(name = "original_release_year") val original_release_year: Int?,
    @field:Json(name = "object_type") val object_type: String?,
    @field:Json(name = "offers") val offers: List<OffersResponseBody>,
    @field:Json(name = "scoring") val scoring: List<ScoringResponseBody>
)

data class OffersResponseBody(
    @field:Json(name = "monetization_type") val monetization_type: String?,
    @field:Json(name = "provider_id") val provider_id: Int?,
    @field:Json(name = "retail_price") val retail_price: Double?,
    @field:Json(name = "last_change_retail_price") val last_change_retail_price: Double?,
    @field:Json(name = "last_change_difference") val last_change_difference: Double?,
    @field:Json(name = "last_change_percent") val last_change_percent: Double?,
    @field:Json(name = "last_change_date") val last_change_date: String?,
    @field:Json(name = "last_change_date_provider_id") val last_change_date_provider_id: String?,
    @field:Json(name = "currency") val currency: String?,
    @field:Json(name = "urls") val urls: UrlsResponseBody?,
    @field:Json(name = "presentation_type") val presentation_type: String?
)

data class UrlsResponseBody(
    @field:Json(name = "standard_web") val standard_web: String?
)

data class LinkApiCompletoResponseBody(
    @field:Json(name = "mOVIE_DETAIL_OVERVIEW") val mOVIE_DETAIL_OVERVIEW: String?
)

data class ScoringResponseBody(
    @field:Json(name = "provider_type") val provider_type: String?,
    @field:Json(name = "value") val value: Double?
)