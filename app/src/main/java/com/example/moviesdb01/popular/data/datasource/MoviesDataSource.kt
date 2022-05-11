package com.example.moviesdb01.popular.data.datasource

import com.example.moviesdb01.popular.data.models.MoviesResponse
import kotlinx.coroutines.flow.Flow

internal interface MoviesDataSource {
    fun getMovies(): Flow<MoviesResponse>
}