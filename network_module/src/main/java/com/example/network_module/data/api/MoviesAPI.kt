package com.example.network_module.data.api

import com.example.network_module.BuildConfig
import com.example.network_module.data.datamodels.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesAPI {
    @GET(BuildConfig.API_KEY)
    suspend fun getMovieDetails(@Query("s") movieName: String): MoviesResponse?
}