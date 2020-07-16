package com.example.videofragmanproject.model


data class FragmanModel(
    val fragmanPhoto: String,
    val title: String,
    val detailFragmanModel: List<DetailFragmanModel>
)

class DetailFragmanModel(
    val yonetmen: String,
    val imdb: String,
    val oyuncular: String,
    val url: String
)
