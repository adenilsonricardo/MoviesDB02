package com.example.moviesdb01.upcoming.domain.repository

import com.example.moviesdb01.upcoming.domain.model.Upcoming
import kotlinx.coroutines.flow.Flow

interface UpcomingRepository {
    fun getUpcoming(): Flow<Upcoming>
}