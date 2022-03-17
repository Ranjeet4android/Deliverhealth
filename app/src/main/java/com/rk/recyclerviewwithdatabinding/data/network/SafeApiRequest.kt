package com.rk.recyclerviewwithdatabinding.data.network

import android.util.Log
import com.rk.recyclerviewwithdatabinding.utils.ApiException
import retrofit2.Response

abstract class SafeApiRequest {

    suspend fun <T : Any> makeApiRequest(work: suspend () -> Response<T>): T {

        val response = work.invoke()

        if (response.isSuccessful) {
            Log.d("response","response"+response.body())
            return response.body()!!
        } else {
            throw ApiException(
                response.code().toString()
            )
        }
    }
}

