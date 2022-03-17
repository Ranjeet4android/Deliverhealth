package com.rk.recyclerviewwithdatabinding.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rk.recyclerviewwithdatabinding.data.repository.HealthRepository
import com.rk.recyclerviewwithdatabinding.data.response.Results
import com.rk.recyclerviewwithdatabinding.utils.Coroutines
import kotlinx.coroutines.Job

class HealthViewModel(private val repository: HealthRepository) : ViewModel() {


    private val _movies by lazy {
        MutableLiveData<Results>()
    }

    // fun getMovies(): LiveData<List<MovieItem>> = movies_

    val movies: LiveData<Results> get() = _movies

    private lateinit var job: Job
    fun getMoviesListFromRepository(){


        job = Coroutines.ioToMainThread(
            {
                repository.getMovies()
            },
            {
                _movies.value = it
            }
        )


    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }

}
