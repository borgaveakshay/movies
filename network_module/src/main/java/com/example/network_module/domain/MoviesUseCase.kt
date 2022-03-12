package com.example.network_module.domain

import com.example.network_module.data.datamodels.MoviesResponse
import com.example.network_module.data.repository.MoviesRepository

class MoviesUseCase(private val repository: MoviesRepository) :
    BaseUseCase<String, MoviesResponse>() {
    override suspend fun createUseCaseExecution(req: String?): MoviesResponse {
        return req?.let {
            repository.getMovies(it)
        } ?: MoviesResponse()
    }
}