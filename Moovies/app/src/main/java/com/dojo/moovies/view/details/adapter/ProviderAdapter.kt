package com.dojo.moovies.view.details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dojo.moovies.R
import com.dojo.moovies.view.interfaces.MovieOnClickListener
import com.dojo.moovies.data.domain.detalhe.Offers
import com.dojo.moovies.view.interfaces.OffersOnClickListener

class ProviderAdapter(
    private val listProviders: ArrayList<Offers>
) : RecyclerView.Adapter<ProviderViewHolder>() {

    private lateinit var offersOnClickListener: OffersOnClickListener

    fun setOnClickListener(
        offersOnClickListener: OffersOnClickListener
    ) {
        this.offersOnClickListener = offersOnClickListener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProviderViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_list_horizontal_movies, parent, false)

        return ProviderViewHolder(view, offersOnClickListener, listProviders)
    }

    override fun onBindViewHolder(
        holder: ProviderViewHolder,
        position: Int
    ) {
        holder.bind(listProviders[position])
    }

    override fun getItemCount(): Int {
        return listProviders.size
    }
}