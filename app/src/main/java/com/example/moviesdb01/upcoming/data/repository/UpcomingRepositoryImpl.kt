package com.example.moviesdb01.upcoming.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.moviesdb01.upcoming.data.datasource.UpcomingDataSource
import com.example.moviesdb01.upcoming.data.mapper.UpcomingMapper
import com.example.moviesdb01.upcoming.domain.model.Upcoming
import com.example.moviesdb01.upcoming.domain.repository.UpcomingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class UpcomingRepositoryImpl(

    private val upcomingDataSource: UpcomingDataSource,
    private val upcomingMapper: UpcomingMapper

) : UpcomingRepository {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun getUpcoming(): Flow<Upcoming> {
        return upcomingDataSource.getUpcoming().map(upcomingMapper::map)
    }
}