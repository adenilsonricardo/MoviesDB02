package com.example.moviesdb01.upcoming.data.datasource

import com.example.moviesdb01.upcoming.data.api.UpcomingApi
import com.example.moviesdb01.upcoming.data.models.UpcomingResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

const val API_KEY = "INSIRA_SUA_CHAVE_AQUI"

class UpcomingDataSourceImpl(private val service: UpcomingApi) : UpcomingDataSource {

    override fun getUpcoming(): Flow<UpcomingResponse> {
        return flow {
            emit(service.getUpcoming(apiKey = API_KEY))
        }
    }
}