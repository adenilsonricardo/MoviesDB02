package com.example.moviesdb01.di

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.moviesdb01.popular.data.api.MoviesApi
import com.example.moviesdb01.popular.data.datasource.MoviesDataSource
import com.example.moviesdb01.popular.data.datasource.MoviesDataSourceImpl
import com.example.moviesdb01.popular.data.mapper.MoviesMapper
import com.example.moviesdb01.popular.data.repository.MoviesRepositoryImpl
import com.example.moviesdb01.popular.domain.repository.MoviesRepository
import com.example.moviesdb01.popular.domain.usecase.MoviesUseCase
import com.example.moviesdb01.popular.presentation.viewModel.MoviesViewModel
import com.example.moviesdb01.upcoming.data.api.UpcomingApi
import com.example.moviesdb01.upcoming.data.datasource.UpcomingDataSource
import com.example.moviesdb01.upcoming.data.datasource.UpcomingDataSourceImpl
import com.example.moviesdb01.upcoming.data.mapper.UpcomingMapper
import com.example.moviesdb01.upcoming.data.repository.UpcomingRepositoryImpl
import com.example.moviesdb01.upcoming.domain.repository.UpcomingRepository
import com.example.moviesdb01.upcoming.domain.usecase.UpcomingUseCase
import com.example.moviesdb01.upcoming.presentation.viewModel.UpcomingViewModel
import com.example.moviesdb01.utils.RetrofitService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal class MoviesModule: FeatureModule() {
    @RequiresApi(Build.VERSION_CODES.N)
    override val dataModule = module {
        factory<MoviesApi> { RetrofitService.retrofit.create(MoviesApi::class.java) }
        factory<UpcomingApi> { RetrofitService.retrofit.create(UpcomingApi::class.java) }
        factory<MoviesDataSource> { MoviesDataSourceImpl(service = get()) }
        factory<UpcomingDataSource> { UpcomingDataSourceImpl(service = get()) }
        factory<MoviesRepository> {
            MoviesRepositoryImpl(
                moviesDataSource = get(),
                moviesMapper = get()
            )
        }
        factory<UpcomingRepository> {
            UpcomingRepositoryImpl(
                upcomingDataSource = get(),
                upcomingMapper = get()
            )
        }
        factory { MoviesMapper() }
        factory { UpcomingMapper() }
    }
    override val domainModule = module {
        factory { MoviesUseCase(repository = get()) }
        factory { UpcomingUseCase(repository = get()) }
    }
    override val presentationModule =
        module {
            viewModel { MoviesViewModel(moviesUseCase = get()) }
            viewModel {
                UpcomingViewModel(upcomingUseCase = get())
            }
        }
}