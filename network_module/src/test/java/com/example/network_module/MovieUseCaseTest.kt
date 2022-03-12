package com.example.network_module

import com.example.network_module.data.datamodels.MoviesResponse
import com.example.network_module.data.datamodels.ResultResource
import com.example.network_module.data.repository.MoviesRepository
import com.example.network_module.domain.MoviesUseCase
import com.example.network_module.utils.TestUtils
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
    fun `should return the result for movie use case`() {
        // GIVEN
        coEvery { repository.getMovies("abc") } returns ResultResource.success(TestUtils.getMovieResponse())

        // WHEN
        val result: ResultResource<MoviesResponse?>
        runBlocking {
            result = useCase("abc")
        }
        // THEN
        Truth.assertThat(result.data).isEqualTo(TestUtils.getMovieResponse())

    }

    @Test
    fun `should return error for the movie use case`() {
        // GIVEN
        coEvery { repository.getMovies("abc") } returns ResultResource.fail<MoviesResponse?>("cannot fetch the records")

        // WHEN
        val result: ResultResource<MoviesResponse?>
        runBlocking {
            result = useCase("abc")
        }
        // THEN
        Truth.assertThat(result.errorMessage).isEqualTo("cannot fetch the records")

    }

}