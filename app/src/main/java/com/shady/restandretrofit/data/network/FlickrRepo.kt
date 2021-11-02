package com.shady.restandretrofit.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FlickrRepo {
    private val tag = "FlickrRepo"
    private val api = FlickrBuilder.flickrApi

    fun fetchInterestingList(): LiveData<String> {
        val liveDataResponse: MutableLiveData<String> = MutableLiveData()
        val flickrResponse: Call<String> = api.fetchPhotos()
        flickrResponse.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                Log.d(tag, "Response Received")
                liveDataResponse.value = response.body()
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.e(tag, "Failed to fetch response")
            }

        })
        return liveDataResponse
    }
}