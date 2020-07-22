package com.example.videofragmanproject.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.videofragmanproject.R
import com.example.videofragmanproject.model.ActorModel


class ActorHolder(container: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(container.context).inflate(R.layout.row_item_actor, container, false)
) {
    val imgActor: ImageView = itemView.findViewById(R.id.actorPhoto)
    val actorName: TextView = itemView.findViewById(R.id.actorName)

    fun bind(actormodel: ActorModel) {
        Glide.with(itemView.context).load(actormodel.actorPhoto).into(imgActor)
        actorName.text = actormodel.actorName
    }
}