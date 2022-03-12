package com.example.network_module.utils

import com.example.network_module.data.datamodels.MoviesResponse
import com.google.gson.Gson

object TestUtils {

    private const val mockResponse = "{\n" +
            "    \"Search\": [\n" +
            "        {\n" +
            "            \"Title\": \"Jab Tak Hai Jaan\",\n" +
            "            \"Year\": \"2012\",\n" +
            "            \"imdbID\": \"tt2176013\",\n" +
            "            \"Type\": \"movie\",\n" +
            "            \"Poster\": \"https://m.media-amazon.com/images/M/MV5BMTUyMzM5OTM5NF5BMl5BanBnXkFtZTcwNTIwMjA3OA@@._V1_SX300.jpg\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"Title\": \"Jab We Met\",\n" +
            "            \"Year\": \"2007\",\n" +
            "            \"imdbID\": \"tt1093370\",\n" +
            "            \"Type\": \"movie\",\n" +
            "            \"Poster\": \"https://m.media-amazon.com/images/M/MV5BYmIzYmY4MGItM2I4YS00OWZhLWFmMzQtYzI2MWY1MmM3NGU1XkEyXkFqcGdeQXVyNjQ2MjQ5NzM@._V1_SX300.jpg\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"Title\": \"Jab Harry Met Sejal\",\n" +
            "            \"Year\": \"2017\",\n" +
            "            \"imdbID\": \"tt5997666\",\n" +
            "            \"Type\": \"movie\",\n" +
            "            \"Poster\": \"https://m.media-amazon.com/images/M/MV5BMjIzMDI2NDUwOV5BMl5BanBnXkFtZTgwNzE2NjU3MjI@._V1_SX300.jpg\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"Title\": \"Miley Jab Hum Tum\",\n" +
            "            \"Year\": \"2008–2010\",\n" +
            "            \"imdbID\": \"tt2367527\",\n" +
            "            \"Type\": \"series\",\n" +
            "            \"Poster\": \"https://m.media-amazon.com/images/M/MV5BMzk0NGNiYTktNTAzOC00NzE5LWIwMDAtZjA2ZWFlMDM0MTZhXkEyXkFqcGdeQXVyNzM4MjU3NzY@._V1_SX300.jpg\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"Title\": \"Jab Jab Phool Khile\",\n" +
            "            \"Year\": \"1965\",\n" +
            "            \"imdbID\": \"tt0305689\",\n" +
            "            \"Type\": \"movie\",\n" +
            "            \"Poster\": \"https://m.media-amazon.com/images/M/MV5BNDEyN2M4ZGMtN2VlNC00MzBlLTkxYjAtNjgzMTU1MDY4MTU3XkEyXkFqcGdeQXVyODE5NzE3OTE@._V1_SX300.jpg\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"Title\": \"Jab Pyar Kisise Hota Hai\",\n" +
            "            \"Year\": \"1961\",\n" +
            "            \"imdbID\": \"tt0230348\",\n" +
            "            \"Type\": \"movie\",\n" +
            "            \"Poster\": \"https://m.media-amazon.com/images/M/MV5BMTg3MTE5Mjk1NF5BMl5BanBnXkFtZTcwMjQyNDE0MQ@@._V1_SX300.jpg\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"Title\": \"Jab Bhi Choom Leta Hoon\",\n" +
            "            \"Year\": \"2004\",\n" +
            "            \"imdbID\": \"tt5478924\",\n" +
            "            \"Type\": \"movie\",\n" +
            "            \"Poster\": \"N/A\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"Title\": \"Against the Jab\",\n" +
            "            \"Year\": \"2015\",\n" +
            "            \"imdbID\": \"tt3496742\",\n" +
            "            \"Type\": \"movie\",\n" +
            "            \"Poster\": \"https://m.media-amazon.com/images/M/MV5BOTIxNDM3NTk1Nl5BMl5BanBnXkFtZTgwODY2OTQyMTE@._V1_SX300.jpg\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"Title\": \"Jab Se Tumhe Dekha Hai\",\n" +
            "            \"Year\": \"1963\",\n" +
            "            \"imdbID\": \"tt0231806\",\n" +
            "            \"Type\": \"movie\",\n" +
            "            \"Poster\": \"https://m.media-amazon.com/images/M/MV5BNmYxMjc2NTktZmM0Mi00NTlkLWIyMjYtZmQwNmMyNzY4NGFhXkEyXkFqcGdeQXVyNDQwOTAzNw@@._V1_SX300.jpg\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"Title\": \"Jab Yaad Kisi Ki Aati Hai\",\n" +
            "            \"Year\": \"1967\",\n" +
            "            \"imdbID\": \"tt0369595\",\n" +
            "            \"Type\": \"movie\",\n" +
            "            \"Poster\": \"https://m.media-amazon.com/images/M/MV5BZDZlZWQ4MWMtNjVhNi00NzA2LWEwOTEtZTMzN2IwMjEzZTA2XkEyXkFqcGdeQXVyODE5NzE3OTE@._V1_SX300.jpg\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"totalResults\": \"49\",\n" +
            "    \"Response\": \"True\"\n" +
            "}"

    fun getMovieResponse(): MoviesResponse = Gson().fromJson(mockResponse, MoviesResponse::class.java)

}