package com.example.moviesdb01.upcoming.data.api

import com.example.moviesdb01.upcoming.data.models.UpcomingResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UpcomingApi {
    @GET("upcoming")
    suspend fun getUpcoming(@Query("api_key") apiKey: String): UpcomingResponse
}