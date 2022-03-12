package com.example.network_module.data.repository

import com.example.network_module.data.datamodels.MoviesResponse
import com.example.network_module.data.datamodels.ResultResource

interface MoviesRepository {
    suspend fun getMovies(search: String): ResultResource<MoviesResponse?>
}