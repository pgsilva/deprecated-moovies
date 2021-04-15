package com.dojo.moovies.data.domain.pesquisa

import com.dojo.moovies.api.network.search.response.OffersResponseBody
import java.io.Serializable

data class Offers(

    val monetization_type: String?,
    val provider_id: Int?,
    val retail_price: Double?,
    val last_change_retail_price: Double?,
    val last_change_difference: Double?,
    val last_change_percent: Double?,
    val last_change_date: String?,
    val last_change_date_provider_id: String?,
    val currency: String?,
    val urls: Urls?,
    val presentation_type: String?
): Serializable {
    constructor(offerSearchResponseBody: OffersResponseBody) : this(
        monetization_type = offerSearchResponseBody.monetization_type,
        provider_id = offerSearchResponseBody.provider_id,
        retail_price = offerSearchResponseBody.retail_price,
        last_change_retail_price = offerSearchResponseBody.last_change_retail_price,
        last_change_difference = offerSearchResponseBody.last_change_difference,
        last_change_percent = offerSearchResponseBody.last_change_percent,
        last_change_date = offerSearchResponseBody.last_change_date,
        last_change_date_provider_id = offerSearchResponseBody.last_change_date_provider_id,
        currency = offerSearchResponseBody.currency,
        urls = Urls(offerSearchResponseBody.urls?.standard_web),
        presentation_type = offerSearchResponseBody.presentation_type,
    )
}