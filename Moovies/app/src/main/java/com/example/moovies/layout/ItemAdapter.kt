package com.example.moovies.layout

import android.content.Context
import android.database.DataSetObserver
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dojo.model.Item
import com.example.moovies.R
import com.example.moovies.resource.JustWatchResource
import java.net.URL


class ItemAdapter(private val items: List<Item>?) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private var exampleListFull: List<Item>? = null
    private val mContext: Context? = null

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var posterImageView: ImageView
        var tituloTextView: TextView

        init {
            posterImageView = itemView.findViewById(R.id.posterImageView)
            tituloTextView = itemView.findViewById(R.id.tituloTextView)

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(
            R.layout.movie_item,
            parent, false
        )
        return ItemViewHolder(v)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem: Item = items!![position]
        val url = URL(JustWatchResource.retornarPosterFilmes(currentItem))
        val bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream())

        holder.posterImageView.setImageBitmap(bmp)
        holder.tituloTextView.setText(currentItem.title)
    }

    override fun getItemCount(): Int {
        if (items != null) {
            return items.size
        }
        return 0
    }
    

}