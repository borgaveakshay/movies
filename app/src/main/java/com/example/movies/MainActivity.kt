package com.example.movies

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies.adapters.MovieAdapter
import com.example.movies.databinding.ActivityMainBinding
import com.example.movies.viewmodels.MoviesViewModel
import com.example.network_module.data.datamodels.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MoviesViewModel>()
    private val movieAdapter by lazy { MovieAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        dataBinding.viewModel = viewModel

        with(dataBinding) {
            showResults.layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            showResults.addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
            showResults.adapter = movieAdapter
        }

        viewModel.movieSearchLiveData.observe(this) {
            when (it.status) {
                Status.LOADING -> {
//                    Toast.makeText(this, "Fetching results..", Toast.LENGTH_SHORT).show()
                }
                Status.ERROR -> {
                    Toast.makeText(this, "Error: ${it.errorMessage}", Toast.LENGTH_LONG).show()
                }
                Status.SUCCESS -> {
                    movieAdapter.submitList(it.data?.Search)
                }
            }
        }
    }
}