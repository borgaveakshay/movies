package com.example.network_module.utils


import com.example.network_module.BuildConfig
import com.example.network_module.data.api.MoviesAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun getRetrofit(): Retrofit {
        val okhttp = HttpLoggingInterceptor()
        okhttp.level = HttpLoggingInterceptor.Level.BODY
        val okhttpClient = OkHttpClient.Builder()
        okhttpClient.addInterceptor(okhttp)
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okhttpClient.build())
            .build()
    }

    @Provides
    @Singleton
    fun getMovieAPI(retrofit: Retrofit): MoviesAPI = retrofit.create(MoviesAPI::class.java)


}