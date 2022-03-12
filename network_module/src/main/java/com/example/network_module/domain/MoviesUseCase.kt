package com.example.network_module.domain

import com.example.network_module.data.datamodels.MoviesResponse
import com.example.network_module.data.datamodels.ResultResource
import com.example.network_module.data.repository.MoviesRepository
import javax.inject.Inject

class MoviesUseCase @Inject constructor(private val repository: MoviesRepository) :
    BaseUseCase<String, ResultResource<MoviesResponse?>>() {
    override suspend fun createUseCaseExecution(req: String?) =
        req?.let { repository.getMovies(req) }
            ?: ResultResource.fail<MoviesResponse?>("request parameter cannot be null")
}