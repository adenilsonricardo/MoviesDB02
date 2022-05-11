package com.example.moviesdb01.popular.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.moviesdb01.popular.data.datasource.MoviesDataSource
import com.example.moviesdb01.popular.data.mapper.MoviesMapper
import com.example.moviesdb01.popular.domain.model.Movies
import com.example.moviesdb01.popular.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class MoviesRepositoryImpl(

    private val moviesDataSource: MoviesDataSource,
    private val moviesMapper: MoviesMapper

) : MoviesRepository {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun getMovies(): Flow<Movies> {
        return moviesDataSource.getMovies().map(moviesMapper::map)
    }
}