package com.shady.restandretrofit.data.network

import com.shady.restandretrofit.BuildConfig
import com.shady.restandretrofit.data.models.FlickrData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrAPI {
    // for a working version, add a flickrAPIKey to your local.properties file, e.g. flickrAPIKey ="nnnnn"
    @GET("?method=flickr.interestingness.getList&api_key=${BuildConfig.flickrAPIKey}&format=json&nojsoncallback=1&extras=url_s")
    suspend fun fetchPhotos(): FlickrData

    @GET("?method=flickr.photos.search&api_key=${BuildConfig.flickrAPIKey}&format=json&nojsoncallback=1&extras=url_s&safe_search=1")
    suspend fun searchPhotos(@Query("text") searchKeyword:String): FlickrData

}