package com.shady.restandretrofit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.shady.restandretrofit.R
import com.shady.restandretrofit.data.network.FlickrRepo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vm = ViewModelProvider(this).get(MainVM::class.java)

        vm.fetchInterestingList().observe(this, {
            Log.d("Flickr Main Response", it.photos.toString())
        })
    }
}