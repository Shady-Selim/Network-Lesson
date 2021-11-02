package com.shady.restandretrofit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.shady.restandretrofit.R
import com.shady.restandretrofit.data.network.FlickrRepo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repo = FlickrRepo()
        val flickrLiveData: LiveData<String> = repo.fetchInterestingList()
        flickrLiveData.observe(this, {
            Log.d("Flickr Activity", "Response received : $it")
        })
    }
}