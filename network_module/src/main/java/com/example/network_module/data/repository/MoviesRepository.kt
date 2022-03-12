package com.example.network_module.data.repository

import com.example.network_module.data.datamodels.MoviesResponse

interface MoviesRepository {
    suspend fun getMovies(search: String): MoviesResponse
}