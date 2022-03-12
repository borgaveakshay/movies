package com.example.network_module.utils


import com.example.network_module.BuildConfig
import com.example.network_module.data.MoviesAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("${BuildConfig.BASE_URL}${BuildConfig.API_KEY}")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getMovieAPI(retrofit: Retrofit): MoviesAPI = retrofit.create(MoviesAPI::class.java)


}