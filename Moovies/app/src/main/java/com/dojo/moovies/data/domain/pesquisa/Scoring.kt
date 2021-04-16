package com.dojo.moovies.data.domain.pesquisa

import java.io.Serializable

data class Scoring(

    val provider_type: String?,
    val value: Double?
) : Serializable