package com.shady.restandretrofit.data.viewModels

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.shady.restandretrofit.data.models.FlickrPhoto

class PhotosViewModel: BaseObservable() {
    var vmPhoto: FlickrPhoto? = null
        set(vmPhoto){
            field = vmPhoto
            notifyChange()
        }

    @get:Bindable
    val title : String?
        get() = vmPhoto?.title
}