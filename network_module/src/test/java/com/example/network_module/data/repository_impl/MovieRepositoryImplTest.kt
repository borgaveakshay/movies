package com.example.network_module.data.repository_impl

import com.example.network_module.data.api.MoviesAPI
import com.example.network_module.data.datamodels.MoviesResponse
import com.example.network_module.data.datamodels.ResultResource
import com.example.network_module.data.repository.MoviesRepository
import com.example.network_module.utils.TestUtils
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.mockkClass
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class MovieRepositoryImplTest {
    private lateinit var repository: MoviesRepository
    private lateinit var moviesAPI: MoviesAPI

    @Before
    fun setup() {
        moviesAPI = mockkClass(MoviesAPI::class)
        repository = MovieRepositoryImpl(moviesAPI)
    }

    @Test
    fun `should return the result for movie repository`() {
        // GIVEN
        coEvery { moviesAPI.getMovieDetails("abc") } returns TestUtils.getMovieResponse()

        // WHEN
        val result: ResultResource<MoviesResponse?>
        runBlocking {
            result = repository.getMovies("abc")
        }
        // THEN
        Truth.assertThat(result.data).isEqualTo(TestUtils.getMovieResponse())

    }

    @Test
    fun `should return error for the movie repository`() {
        // GIVEN
        coEvery { moviesAPI.getMovieDetails("abc") } returns null

        // WHEN
        val result: ResultResource<MoviesResponse?>
        runBlocking {
            result = repository.getMovies("abc")
        }
        // THEN
        Truth.assertThat(result.data).isEqualTo(null)

    }

}