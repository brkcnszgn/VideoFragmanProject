package com.example.videofragmanproject.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.videofragmanproject.data.model.ActorModel


class ActorAdapter(private val actorList: List<ActorModel>) : RecyclerView.Adapter<ActorHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorHolder {
        return ActorHolder(parent)
    }

    override fun getItemCount(): Int = actorList.size

    override fun onBindViewHolder(holder: ActorHolder, position: Int) {
        holder.bind(actorList[position])
    }
}