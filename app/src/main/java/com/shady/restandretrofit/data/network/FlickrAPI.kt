package com.shady.restandretrofit.data.network

import retrofit2.Call
import retrofit2.http.GET

interface FlickrAPI {

    @GET("method=flickr.interestingness.getList&api_key=1429a3752b5d2658fecb7bd8d46d71bc&format=json&nojsoncallback=1&extras=url_s")
    fun fetchPhotos(): Call<String>
}