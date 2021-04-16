package com.dojo.moovies.view.details.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dojo.moovies.R
import com.dojo.moovies.data.domain.detalhe.Offers
import com.dojo.moovies.util.JustWatchApiData
import com.dojo.moovies.util.JustWatchApiData.Companion.recuperarUrlProvider
import com.dojo.moovies.view.interfaces.MovieOnClickListener
import com.dojo.moovies.view.interfaces.OffersOnClickListener
import com.squareup.picasso.Picasso

class ProviderViewHolder(
    itemView: View,
    onClickListener: OffersOnClickListener,
    listProviders: ArrayList<Offers>
) : RecyclerView.ViewHolder(itemView) {

    init {
        itemView.setOnClickListener {
            val positionRcy = adapterPosition
            if (positionRcy != RecyclerView.NO_POSITION) {
                onClickListener.onItemClick(listProviders[positionRcy])
                // println(listProviders[positionRcy])
            }
        }
    }

    fun bind(offer: Offers) {
        val tvType = itemView.findViewById(R.id.tv_type) as TextView
        val ivPoster = itemView.findViewById(R.id.iv_provider_logo) as ImageView

        tvType.text = offer.presentation_type
        Picasso.get()
            .load(recuperarUrlProvider(offer.provider_id))
            .into(ivPoster)
    }
}