package com.example.network_module

import com.example.network_module.data.datamodels.MoviesResponse
import com.example.network_module.data.datamodels.TestUtils
import com.example.network_module.data.repository.MoviesRepository
import com.example.network_module.domain.MoviesUseCase
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.mockkClass
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class MovieUseCaseTest {

    private lateinit var repository: MoviesRepository
    private lateinit var useCase: MoviesUseCase

    @Before
    fun setup() {
        repository = mockkClass(MoviesRepository::class)
        useCase = MoviesUseCase(repository)
    }

    @Test
    fun should_return_movies_for_use_case() {
        // GIVEN
        coEvery { repository.getMovies("abc") } returns TestUtils.getMovieResponse()

        // WHEN
        val result: MoviesResponse
        runBlocking {
            result = useCase("abc")
        }
        // THEN
        Truth.assertThat(result).isEqualTo(TestUtils.getMovieResponse())

    }


}