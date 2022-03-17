package com.rk.recyclerviewwithdatabinding.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rk.recyclerviewwithdatabinding.data.repository.HealthRepository

@Suppress("UNCHECKED_CAST")
class HeathViewModelFactory(private val moviesRepository: HealthRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return HealthViewModel(
            moviesRepository
        ) as T
    }
}