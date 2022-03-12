package com.example.network_module.di

import com.example.network_module.data.api.MoviesAPI
import com.example.network_module.data.repository.MoviesRepository
import com.example.network_module.data.repository_impl.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun getMovieRepository(moviesAPI: MoviesAPI): MoviesRepository = MovieRepositoryImpl(moviesAPI)
}