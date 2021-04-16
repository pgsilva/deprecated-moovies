package com.alvarengadev.alvaflix.view.search.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dojo.moovies.view.interfaces.MovieOnClickListener
import com.dojo.moovies.R
import com.dojo.moovies.data.domain.pesquisa.Item
import com.dojo.moovies.util.JustWatchApiData.Companion.recuperarUrlPoster
import com.squareup.picasso.Picasso


class SearchViewHolder(
    itemView: View,
    onClickListener: MovieOnClickListener?,
    listMovieSearch: ArrayList<Item>
) : RecyclerView.ViewHolder(itemView) {

    init {
        itemView.setOnClickListener {
            val positionRcy = adapterPosition
            if (positionRcy != RecyclerView.NO_POSITION) {
                onClickListener?.onItemClick(listMovieSearch[positionRcy])
            }
        }
    }

    fun bind(searchMovie: Item?) {
        val ivPoster = itemView.findViewById(R.id.iv_movie_poster_search) as ImageView
        val tvTitle = itemView.findViewById(R.id.tv_title_movie_search) as TextView


        Picasso.get()
            .load(recuperarUrlPoster(searchMovie))
            .into(ivPoster)

        tvTitle.text = searchMovie?.title

    }
}