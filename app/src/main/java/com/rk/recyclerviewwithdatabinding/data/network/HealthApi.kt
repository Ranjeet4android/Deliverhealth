package com.rk.recyclerviewwithdatabinding.data.network

import com.rk.recyclerviewwithdatabinding.data.response.Results
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface HealthApi {

    companion object {
        //Whenever we will write MoviesApi(),it will call invoke() function automatically

        operator fun invoke(): HealthApi {

            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
            return Retrofit.Builder()
                .client(client)
                .baseUrl("https://duet-public-content.s3.us-east-2.amazonaws.com/")//"https://api.androidhive.info/json/"
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(HealthApi::class.java)
        }

    }

    @GET("project.json")//movies.json
    suspend fun getMoviesList(): Response<Results>
}