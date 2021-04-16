package com.dojo.moovies.view.interfaces

import com.dojo.moovies.data.domain.detalhe.Offers
import com.dojo.moovies.data.domain.pesquisa.Item

interface MovieOnClickListener {
    fun onItemClick(item: Item)
}

interface OffersOnClickListener {
    fun onItemClick(item: Offers)
}