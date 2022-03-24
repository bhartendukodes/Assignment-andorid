package com.example.androidassignment.repo

import com.example.androidassignment.model.Image
import com.example.androidassignment.model.ImageItem

object Repository {

    private val apiService by lazy {
        Retrofit.getApiServices()
    }

    suspend fun getImageList():Image
    {
        return apiService.getImageList()
    }
}