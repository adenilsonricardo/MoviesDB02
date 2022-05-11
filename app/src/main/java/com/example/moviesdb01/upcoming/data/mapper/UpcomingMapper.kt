package com.example.moviesdb01.upcoming.data.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.moviesdb01.upcoming.data.models.ResultsResponse
import com.example.moviesdb01.utils.Mapper
import com.example.moviesdb01.upcoming.data.models.UpcomingResponse
import com.example.moviesdb01.upcoming.domain.model.Upcoming
import com.example.moviesdb01.upcoming.domain.model.UpcomingResult

@RequiresApi(Build.VERSION_CODES.N)
class UpcomingMapper : Mapper<UpcomingResponse, Upcoming> {

    override fun map(source: UpcomingResponse): Upcoming {
        return Upcoming(
            page = 0,
            results = source.results?.let { mapResults(it) },
            totalPages = 0,
            totalResults = 0,
        )
    }

    private fun mapResults(statusResult: List<ResultsResponse>): List<UpcomingResult> {
        return statusResult.map {
            UpcomingResult(
                adult = it.adult,
                backdropPath = it.backdropPath,
                genreIds = it.genreIds,
                id = it.id,
                originalLanguage = it.originalLanguage,
                originalTitle = it.originalTitle,
                overview = it.overview,
                popularity = it.popularity,
                posterPath = it.posterPath,
                releaseDate = it.releaseDate,
                title = it.title,
                video = it.video,
                voteAverage = it.voteAverage,
                voteCount = it.voteCount
            )
        }
    }
}