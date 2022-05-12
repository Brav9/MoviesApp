package com.hfad.moviesapp.di

import com.hfad.moviesapp.data.network.ApiService
import com.hfad.moviesapp.data.network.ReviewsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun baseUrl() = "https://api.tvmaze.com/"

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String): ApiService =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

    @Provides
    @Named("REVIEW_BASE_URL")
    fun baseReviewsUrl() = "https://api.nytimes.com/"

    @Provides
    @Singleton
    fun provideReviewsRetrofit(@Named("REVIEW_BASE_URL") baseReviewsUrl: String): ReviewsApiService =
        Retrofit.Builder()
            .baseUrl(baseReviewsUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ReviewsApiService::class.java)
}


