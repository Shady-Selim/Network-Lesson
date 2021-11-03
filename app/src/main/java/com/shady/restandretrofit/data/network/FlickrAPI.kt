package com.shady.restandretrofit.data.network

import com.shady.restandretrofit.BuildConfig
import com.shady.restandretrofit.data.models.FlickrData
import retrofit2.Call
import retrofit2.http.GET

interface FlickrAPI {
    @GET("?method=flickr.interestingness.getList&api_key=${BuildConfig.flickrAPIKey}&format=json&nojsoncallback=1&extras=url_s")
    suspend fun fetchPhotos(): FlickrData
}