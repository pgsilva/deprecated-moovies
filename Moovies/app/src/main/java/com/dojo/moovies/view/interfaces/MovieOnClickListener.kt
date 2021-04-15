package com.alvarengadev.alvaflix.view.interfaces

import com.dojo.moovies.data.domain.pesquisa.Item

interface MovieOnClickListener {
    fun onItemClick(item: Item)
}