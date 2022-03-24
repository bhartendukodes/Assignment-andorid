package com.example.androidassignment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidassignment.model.Image
import com.example.androidassignment.model.ImageItem
import com.example.androidassignment.repo.Repository
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeViewModel():ViewModel() {

    val listImage = MutableLiveData<Image>()

    fun getImageList()
    {
        try {
            viewModelScope.launch {
                val imageList = Repository.getImageList()
                listImage.postValue(imageList)
            }
        }
        catch (e: Exception)
        {
            e.printStackTrace()
        }
    }
}