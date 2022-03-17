package com.rk.recyclerviewwithdatabinding.data.repository

import com.rk.recyclerviewwithdatabinding.data.network.HealthApi
import com.rk.recyclerviewwithdatabinding.data.network.SafeApiRequest

class HealthRepository(private val api: HealthApi) : SafeApiRequest() {

    suspend fun getMovies() = makeApiRequest {
        api.getMoviesList()
    }

}