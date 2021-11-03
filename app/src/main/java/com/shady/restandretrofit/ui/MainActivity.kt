package com.shady.restandretrofit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.shady.restandretrofit.R

class MainActivity : AppCompatActivity() {
    private lateinit var flickrRV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vm = ViewModelProvider(this).get(MainVM::class.java)

        flickrRV = findViewById(R.id.rvFlickr)
        flickrRV.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)  //GridLayoutManager(this, 2)

        vm.fetchInterestingList().observe(this, {
            flickrRV.adapter = FlickrAdapter(it.photos.photo)
            Log.d("Flickr Main Response", it.photos.toString())
        })
    }
}