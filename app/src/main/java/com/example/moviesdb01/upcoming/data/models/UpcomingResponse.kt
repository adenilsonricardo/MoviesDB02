package com.example.moviesdb01.upcoming.data.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class UpcomingResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<ResultsResponse>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)