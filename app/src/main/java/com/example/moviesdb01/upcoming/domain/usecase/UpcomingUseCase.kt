package com.example.moviesdb01.upcoming.domain.usecase

import com.example.moviesdb01.upcoming.domain.model.Upcoming
import com.example.moviesdb01.upcoming.domain.repository.UpcomingRepository
import kotlinx.coroutines.flow.Flow

class UpcomingUseCase(
    private val repository: UpcomingRepository,
) {
    operator fun invoke(): Flow<Upcoming> {
        return repository.getUpcoming()
    }
}