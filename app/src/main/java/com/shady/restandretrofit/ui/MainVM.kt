package com.shady.restandretrofit.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shady.restandretrofit.data.models.FlickrData
import com.shady.restandretrofit.data.network.FlickrRepo
import kotlinx.coroutines.launch

class MainVM: ViewModel() {
    val repo = FlickrRepo()
    fun fetchInterestingList(searchKeyword: String?): LiveData<FlickrData>{
        val photos = MutableLiveData<FlickrData>()
            viewModelScope.launch {
                try {
                    if (searchKeyword.isNullOrEmpty()){
                        photos.postValue(repo.fetchInterestingList())
                    } else {
                        photos.postValue(repo.searchPhotos(searchKeyword))
                    }
                } catch (e: Throwable) {
                    Log.e("Flickr Image","Flickr Image Problem: ${e.localizedMessage}")
                }
            }
        return photos
    }
}