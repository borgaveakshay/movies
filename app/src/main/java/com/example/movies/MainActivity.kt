package com.example.movies

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.movies.viewmodels.MoviesViewModel
import com.example.network_module.data.datamodels.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MoviesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.searchMovies("Jab We Met")

        viewModel.movieSearchLiveData.observe(this) {
            when (it.status) {
                Status.LOADING -> {
                    Toast.makeText(this, "Fetching results..", Toast.LENGTH_SHORT).show()
                }
                Status.ERROR -> {
                    Toast.makeText(this, "Error: ${it.errorMessage}", Toast.LENGTH_LONG).show()
                }
                Status.SUCCESS -> {
                    Toast.makeText(this, it.data?.Search?.size.toString(), Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}