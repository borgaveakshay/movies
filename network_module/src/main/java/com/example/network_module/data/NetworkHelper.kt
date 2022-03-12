package com.example.network_module.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkHelper {

    fun getRetrofit() = Retrofit.Builder()
        .baseUrl("http://www.omdbapi.com/?apikey=24db60e1&")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


}