package com.example.moviesdb01.upcoming.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesdb01.upcoming.domain.model.Upcoming
import com.example.moviesdb01.upcoming.domain.usecase.UpcomingUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class UpcomingViewModel(

    private val upcomingUseCase: UpcomingUseCase,
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _upcoming: MutableLiveData<Upcoming> = MutableLiveData()
    val upcoming: LiveData<Upcoming> = _upcoming
    private val _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String> = _error

    init {
        getUpcoming()
    }

    private fun getUpcoming() {
        viewModelScope.launch {
            upcomingUseCase()
                .flowOn(coroutineDispatcher)
                .catch { exception ->
                    _error.value = exception.message
                }
                .collect { upcomingList ->
                    _upcoming.value = upcomingList
                }
        }
    }
}