package com.example.movies.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.network_module.data.datamodels.MoviesResponse
import com.example.network_module.data.datamodels.ResultResource
import com.example.network_module.domain.movie_usecases.MoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val moviesUseCase: MoviesUseCase
) : ViewModel() {

    val movieSearchLiveData = MutableLiveData<ResultResource<MoviesResponse?>>()

    fun searchMovies(query: CharSequence) {
        movieSearchLiveData.postValue(ResultResource.loading<MoviesResponse?>())
        viewModelScope.launch {
            movieSearchLiveData.postValue(moviesUseCase(query.toString()))
        }
    }

}