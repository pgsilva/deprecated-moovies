package com.dojo.moovies.api.mapper

import com.dojo.moovies.api.network.search.response.MovieSearchResponseBody
import com.dojo.moovies.api.network.search.response.OffersResponseBody
import com.dojo.moovies.api.network.search.response.ScoringResponseBody
import com.dojo.moovies.data.domain.pesquisa.Item
import com.dojo.moovies.data.domain.pesquisa.LinkApiCompleto
import com.dojo.moovies.data.domain.pesquisa.Offers
import com.dojo.moovies.data.domain.pesquisa.Scoring

class MovieSearchMapper {
    companion object {
        fun responseToDomain(listResponseBody: ArrayList<MovieSearchResponseBody>): ArrayList<Item> {
            val listMovieSearch = ArrayList<Item>()
            for (movieSearchResponse in listResponseBody) {
                if (movieSearchResponse.id != null) {
                    val movieSearch = Item(
                        jw_entity_id = movieSearchResponse.jw_entity_id,
                        id = movieSearchResponse.id,
                        title = movieSearchResponse.title,
                        full_path = movieSearchResponse.full_path,
                        full_paths = LinkApiCompleto(movieSearchResponse.full_paths?.mOVIE_DETAIL_OVERVIEW),
                        poster = movieSearchResponse.poster,
                        poster_blur_hash = movieSearchResponse.poster_blur_hash,
                        original_release_year = movieSearchResponse.original_release_year,
                        object_type = movieSearchResponse.object_type,
                        offers = constroiListOffersResponse(movieSearchResponse.offers),
                        scoring = constroiListScoringResponse(movieSearchResponse.scoring),
                    )

                    listMovieSearch.add(movieSearch)
                }
            }
            return listMovieSearch
        }

        private fun constroiListScoringResponse(scoring: List<ScoringResponseBody>?): List<Scoring> {
            val list = ArrayList<Scoring>()
            scoring?.forEach { sco ->
                list.add(Scoring(sco))
            }

            return list.toList()
        }

        fun constroiListOffersResponse(offers: List<OffersResponseBody>?): List<Offers> {

            val list = ArrayList<Offers>()
            offers?.forEach { offersResponseBody ->
                list.add(Offers(offersResponseBody))
            }

            return list.toList()
        }
    }
}