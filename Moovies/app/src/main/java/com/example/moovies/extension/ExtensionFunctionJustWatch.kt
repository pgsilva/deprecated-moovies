package com.example.moovies.extension

import com.dojo.model.Resultado

fun Resultado.firstItemTitle(): String =
    this.items.first().title ?: "Nenhum Resultado Encontrado"