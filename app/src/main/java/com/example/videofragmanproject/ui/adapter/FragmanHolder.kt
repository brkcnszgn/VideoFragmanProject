package com.example.videofragmanproject.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.videofragmanproject.R
import com.example.videofragmanproject.data.model.FragmanModel


class FragmanHolder(container: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(container.context).inflate(R.layout.row_item_frg, container, false)
) {
    private val imageView: ImageView = itemView.findViewById(R.id.img_fragman)
    private val title: TextView = itemView.findViewById(R.id.tv_title)

    fun bind(fragmanmodel: FragmanModel, onItemClickListener: (FragmanModel) -> Unit) {
        Glide.with(itemView.context).load(fragmanmodel.fragmanPhoto).into(imageView)
        title.text = fragmanmodel.title
        itemView.setOnClickListener {
            onItemClickListener(fragmanmodel)
        }
    }
}