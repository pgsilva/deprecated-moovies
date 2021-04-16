package com.dojo.moovies.data.domain.pesquisa

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
) : Serializable