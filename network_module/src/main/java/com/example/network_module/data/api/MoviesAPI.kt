package com.example.network_module.data.api

import com.example.network_module.data.datamodels.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesAPI {
    @GET("s={movieName}")
    suspend fun getMovieDetails(@Path("movieName") movieName: String): MoviesResponse?
}