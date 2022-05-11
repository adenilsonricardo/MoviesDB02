package com.example.moviesdb01.upcoming.data.datasource

import com.example.moviesdb01.upcoming.data.models.UpcomingResponse
import kotlinx.coroutines.flow.Flow

interface UpcomingDataSource {
    fun getUpcoming(): Flow<UpcomingResponse>
}