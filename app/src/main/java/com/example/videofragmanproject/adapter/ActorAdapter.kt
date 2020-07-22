package com.example.videofragmanproject.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.videofragmanproject.holder.ActorHolder
import com.example.videofragmanproject.model.ActorModel


class ActorAdapter(val actorList: List<ActorModel>) : RecyclerView.Adapter<ActorHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorHolder {
        return ActorHolder(parent)
    }

    override fun getItemCount(): Int = actorList.size

    override fun onBindViewHolder(holder: ActorHolder, position: Int) {
        holder.bind(actorList[position])
    }
}