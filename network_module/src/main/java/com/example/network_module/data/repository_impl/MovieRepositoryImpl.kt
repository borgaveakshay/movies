package com.example.network_module.data.repository_impl

import com.example.network_module.data.MoviesAPI
import com.example.network_module.data.datamodels.MoviesResponse
import com.example.network_module.data.datamodels.ResultResource
import com.example.network_module.data.repository.MoviesRepository

class MovieRepositoryImpl(private val moviesAPI: MoviesAPI) : MoviesRepository {
    override suspend fun getMovies(search: String) = try {
        ResultResource.success(moviesAPI.getMovieDetails(search))
    } catch (e: Exception) {
        ResultResource.fail<MoviesResponse>(e.message)
    }
}