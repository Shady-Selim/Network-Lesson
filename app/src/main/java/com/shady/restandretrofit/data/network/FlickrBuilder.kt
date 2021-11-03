package com.shady.restandretrofit.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FlickrBuilder {
    private const val BASE_URL = "https://api.flickr.com/services/rest/"
    private fun retrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val flickrApi: FlickrAPI = retrofit().create(FlickrAPI::class.java)
}