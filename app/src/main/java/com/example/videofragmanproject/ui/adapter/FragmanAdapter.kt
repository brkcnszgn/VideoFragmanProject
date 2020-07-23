package com.example.videofragmanproject.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.videofragmanproject.data.model.FragmanModel


class FragmanAdapter(
    private val fragmanlist: List<FragmanModel>,
    private val onItemClickListener: (FragmanModel) -> Unit
) : RecyclerView.Adapter<FragmanHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FragmanHolder {
        return FragmanHolder(parent)
    }

    override fun getItemCount(): Int = fragmanlist.size

    override fun onBindViewHolder(holder: FragmanHolder, position: Int) {
        holder.bind(fragmanlist[position], onItemClickListener)
    }

}
