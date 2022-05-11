package com.example.moviesdb01.upcoming.domain.model


data class Upcoming(

    val page: Int,
    val results: List<UpcomingResult>?,
    val totalPages: Int?,
    val totalResults: Int?
)