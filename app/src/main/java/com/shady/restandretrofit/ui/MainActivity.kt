package com.shady.restandretrofit.ui

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.shady.restandretrofit.R

class MainActivity : AppCompatActivity() {
    private lateinit var flickrRV: RecyclerView
    private val vm by lazy {
        ViewModelProvider(this).get(MainVM::class.java)
    }
    private lateinit var sharedPreferences: SharedPreferences
    private val SHARED_KEY = "lastSearch"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        flickrRV = findViewById(R.id.rvFlickr)
        flickrRV.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)  //GridLayoutManager(this, 2)
        sharedPreferences = this.getSharedPreferences("flickrSearchSharePreference", Context.MODE_PRIVATE)
        loadFlickrImages()
    }

    private fun loadFlickrImages(query: String? = null) {
        vm.fetchInterestingList(query).observe(this, {
            if(query.isNullOrEmpty()){
                flickrRV.adapter = FlickrAdapter(it.photos.photo)
            } else {
                flickrRV.swapAdapter(FlickrAdapter(it.photos.photo), false)
            }
            Log.d("Flickr Main Response", it.photos.toString())
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        val TAG = "searchView"
        val searchIcon: MenuItem =  menu!!.findItem(R.id.app_bar_search)
        val searchView = searchIcon.actionView as SearchView
        searchView.apply {
            setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    Log.d(TAG, "QueryTextSubmit: $query")
                    val sharePref = sharedPreferences.getString(SHARED_KEY, "This was your 1st Search!! Yay!!")
                    Toast.makeText(context, sharePref, Toast.LENGTH_LONG).show()
                    sharedPreferences
                        .edit()
                        .putString(SHARED_KEY, "Your last search was: $query")
                        .apply()
                    loadFlickrImages(query?.trim())
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    Log.d(TAG, "QueryTextSubmit: $newText")
                    return false
                }


            })
        }

        return super.onCreateOptionsMenu(menu)
    }

}