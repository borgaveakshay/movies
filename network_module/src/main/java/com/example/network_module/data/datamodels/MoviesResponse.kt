package com.example.network_module.data.datamodels

data class MoviesResponse(
    val Response: String = "",
    val Search: List<Search> = listOf(),
    val totalResults: String = ""
)

data class Search(
    val Poster: String = "",
    val Title: String = "",
    val Type: String = "",
    val Year: String = "",
    val imdbID: String = ""
)