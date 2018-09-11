package com.larapin.kotlinsub3.favorite

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.larapin.kotlinsub3.R
import com.larapin.kotlinsub3.db.FavoriteEvent
import kotlinx.android.synthetic.main.item_event.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Avin on 11/09/2018.
 *
 */
class FavoriteEventAdapter(private val context: Context, private val favorite: List<FavoriteEvent>, private val listener: (FavoriteEvent) -> Unit)
    : RecyclerView.Adapter<FavoriteEventViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteEventViewHolder {
        return FavoriteEventViewHolder((LayoutInflater.from(context).inflate(R.layout.item_event, parent, false)))
    }

    override fun getItemCount(): Int = favorite.size

    override fun onBindViewHolder(holder: FavoriteEventViewHolder, position: Int) {
        holder.bindItem(favorite[position], listener)
    }
}

class FavoriteEventViewHolder(view: View) : RecyclerView.ViewHolder(view){
    fun bindItem(favorite: FavoriteEvent, listener: (FavoriteEvent) -> Unit){
        val tanggalbaru = SimpleDateFormat("EEE, d MMM yyyy")
                .format(SimpleDateFormat("yyyy-MM-dd")
                        .parse(favorite.eventDate))
        itemView.tv_date.text = tanggalbaru
        itemView.tv_home.text = favorite.teamHome
        itemView.tv_skor.text = favorite.scoreHome+"   VS   "+favorite.scoreAway
        itemView.tv_away.text = favorite.teamAway
        itemView.onClick { listener(favorite) }
    }

}