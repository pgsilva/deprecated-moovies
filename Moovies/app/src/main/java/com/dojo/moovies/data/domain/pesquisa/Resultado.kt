package com.dojo.moovies.data.domain.pesquisa

import java.io.Serializable

data class Resultado(

    val page: Int?,
    val page_size: Int?,
    val total_pages: Int?,
    val total_results: Int?,
    val items: ArrayList<Item?>?
): Serializable