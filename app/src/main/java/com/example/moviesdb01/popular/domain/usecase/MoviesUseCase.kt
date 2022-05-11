package com.example.moviesdb01.popular.domain.usecase

import com.example.moviesdb01.popular.domain.model.Movies
import com.example.moviesdb01.popular.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow

class MoviesUseCase(
    private val repository: MoviesRepository,
){
    operator fun invoke(): Flow<Movies> {
        return repository.getMovies()
    }
}