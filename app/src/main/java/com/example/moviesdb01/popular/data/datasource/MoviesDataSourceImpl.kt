package com.example.moviesdb01.popular.data.datasource

import com.example.moviesdb01.popular.data.api.MoviesApi
import com.example.moviesdb01.popular.data.models.MoviesResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

const val API_KEY = "INSIRA_SUA_CHAVE_AQUI"

class MoviesDataSourceImpl(private val service: MoviesApi): MoviesDataSource  {

    override fun getMovies(): Flow<MoviesResponse> {
        return flow{
            emit(service.getMovies(apiKey = API_KEY))
        }
    }
}