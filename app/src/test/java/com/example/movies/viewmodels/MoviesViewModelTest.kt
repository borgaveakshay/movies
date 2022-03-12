package com.example.movies.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.movies.TestCoroutineRule
import com.example.network_module.data.datamodels.MoviesResponse
import com.example.network_module.data.datamodels.ResultResource
import com.example.network_module.data.repository.MoviesRepository
import com.example.network_module.domain.movie_usecases.MoviesUseCase
import com.example.network_module.utils.TestUtils
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.mockkClass
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MoviesViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()


    @get:Rule
    val coroutineRule = TestCoroutineRule()

    private lateinit var movieUseCase: MoviesUseCase
    private lateinit var repository: MoviesRepository
    private lateinit var viewModel: MoviesViewModel

    @Before
    fun setup() {
        repository = mockkClass(MoviesRepository::class)
        movieUseCase = MoviesUseCase(repository)
        viewModel = MoviesViewModel(movieUseCase)
    }


    @Test
    fun `view model should return movie details`() {
        // GIVEN
        coEvery { movieUseCase("abc") } returns ResultResource.success(TestUtils.getMovieResponse())

        // WHEN
        var result: ResultResource<MoviesResponse?>? = null
        viewModel.searchMovies("abc")
        viewModel.movieSearchLiveData.observeForever {
            result = it
        }

        // THEN
        Truth.assertThat(result?.data).isEqualTo(TestUtils.getMovieResponse())

    }

    @Test
    fun `view model should return error for movie details`() {
        // GIVEN
        val error = "Error while fetching movie details"
        coEvery { movieUseCase("abc") } returns ResultResource.fail<MoviesResponse?>(error)

        // WHEN
        var result: ResultResource<MoviesResponse?>? = null
        viewModel.searchMovies("abc")
        viewModel.movieSearchLiveData.observeForever {
            result = it
        }

        // THEN
        Truth.assertThat(result?.errorMessage).isEqualTo(error)

    }
}