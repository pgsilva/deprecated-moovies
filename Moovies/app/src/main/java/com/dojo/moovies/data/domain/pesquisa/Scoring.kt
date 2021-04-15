package com.dojo.moovies.data.domain.pesquisa

import com.dojo.moovies.api.network.search.response.ScoringResponseBody
import java.io.Serializable

data class Scoring(

    val provider_type: String?,
    val value: Double?
): Serializable {
    constructor(scoringResponseBody: ScoringResponseBody) : this(
        scoringResponseBody.provider_type,
        scoringResponseBody.value
    )
}