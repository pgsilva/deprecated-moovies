package com.dojo.moovies.data.dao

import com.dojo.moovies.data.domain.canais.ServicoStream

class ServicoStreamDao {
    companion object {
        private var servicoStream: List<ServicoStream> = ArrayList<ServicoStream>()

        fun atualizaListaDeServicosStream(listaServicoStream: List<ServicoStream>) {
            this.servicoStream = listaServicoStream
        }

        fun getUrlIconeServico(id: Int): String? {
            return servicoStream.find { it.id == id }?.icon_url
        }

    }

}

