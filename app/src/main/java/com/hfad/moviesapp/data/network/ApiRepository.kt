package com.hfad.moviesapp.data.network

import android.app.Application
import com.hfad.moviesapp.R
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private val context: Application,
    private val apiService: ApiService,
    private val reviewsApiService: ReviewsApiService
) {

    suspend fun getAllMovies() = apiService.getAllMovies()

    suspend fun getAllReviews() = reviewsApiService.getReviews(context.getString(R.string.reviews_api_key))

}