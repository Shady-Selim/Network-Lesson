package com.shady.restandretrofit.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shady.restandretrofit.data.models.FlickrData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FlickrRepo {
    private val tag = "FlickrRepo"
    private val api = FlickrBuilder.flickrApi

    suspend fun fetchInterestingList(): FlickrData = withContext(Dispatchers.IO) {
        api.fetchPhotos()
    }
}