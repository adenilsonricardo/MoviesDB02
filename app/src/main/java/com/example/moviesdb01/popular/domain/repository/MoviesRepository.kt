package com.example.moviesdb01.popular.domain.repository

import com.example.moviesdb01.popular.domain.model.Movies
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun getMovies(): Flow<Movies>
}