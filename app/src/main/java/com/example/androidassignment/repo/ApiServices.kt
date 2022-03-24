package com.example.androidassignment.repo

import com.example.androidassignment.model.Image
import retrofit2.http.GET

interface ApiServices {

    @GET("/v2/list")
    suspend fun getImageList():Image
}