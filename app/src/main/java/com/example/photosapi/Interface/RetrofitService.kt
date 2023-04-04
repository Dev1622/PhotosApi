package com.example.photosapi.Interface

import com.example.photosapi.Model.Photo
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("photos")
    fun getPhotoList() : Call<MutableList<Photo>>
}