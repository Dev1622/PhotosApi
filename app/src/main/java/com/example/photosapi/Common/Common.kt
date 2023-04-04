package com.example.photosapi.Common

import com.example.photosapi.Interface.RetrofitService
import com.example.photosapi.Retrofit.RetrofitClient
import retrofit2.create

object Common {
    private val BASE_URL = "https://jsonplaceholder.typicode.com/"

            val retrofitService : RetrofitService
            get() = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
}