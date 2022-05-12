package com.hfad.moviesapp.data.models

import com.google.gson.annotations.SerializedName

data class ReviewResponse(
    val result: List<Review>
)

data class Review(
    @SerializedName("display_title")
    val title: String,
    @SerializedName("headline")
    val headline: String,
    @SerializedName("byline")
    val byline: String,
    @SerializedName("summary_short")
    val summary: String,
    @SerializedName("multimedia")
    val multimedia: Multimedia
)

data class Multimedia(
    val src: String
)
