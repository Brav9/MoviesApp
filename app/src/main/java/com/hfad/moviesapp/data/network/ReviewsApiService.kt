package com.hfad.moviesapp.data.network

import com.hfad.moviesapp.data.models.ReviewResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ReviewsApiService {

    @GET("svc/movies/v2/reviews/all.json")
    suspend fun getReviews(
        @Query("api-key") key: String
    ): Response<ReviewResponse>
}