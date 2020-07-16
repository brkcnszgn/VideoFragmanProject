package com.example.videofragmanproject.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.videofragmanproject.holder.FragmanHolder
import com.example.videofragmanproject.model.FragmanModel


class FragmanAdapter(val fragmanlist: List<FragmanModel>) : RecyclerView.Adapter<FragmanHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FragmanHolder {
        return FragmanHolder(parent)
    }

    override fun getItemCount(): Int = fragmanlist.size

    override fun onBindViewHolder(holder: FragmanHolder, position: Int) {
        holder.bind(fragmanlist[position])
    }

}
