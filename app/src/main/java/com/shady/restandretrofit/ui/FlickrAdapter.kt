package com.shady.restandretrofit.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.shady.restandretrofit.R
import com.shady.restandretrofit.data.models.FlickrPhoto
import com.shady.restandretrofit.data.viewModels.PhotosViewModel
import com.shady.restandretrofit.databinding.FlickrRecycleviewItemBinding

class FlickrAdapter(val photosData: List<FlickrPhoto>) : RecyclerView.Adapter<CustomHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.flickr_recycleview_item, parent, false)
        val bind: FlickrRecycleviewItemBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.flickr_recycleview_item, parent, false)
        return CustomHolder(bind)
    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
        val photo = photosData[position]
        holder.bind(photo)
    }

    override fun getItemCount(): Int = photosData.size
}

class CustomHolder(val binding : FlickrRecycleviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
    // val titleTV: TextView = itemView.findViewById(R.id.tvFlickr)
   // val imageIV: ImageView = itemView.findViewById(R.id.ivFlickr)
    init {
        binding.vm = PhotosViewModel()
    }

    fun bind(photo: FlickrPhoto) {
        binding.ivFlickr.load(photo.url)
        binding.vm?.vmPhoto = photo
        /*titleTV.text = photo.title
        imageIV.load(photo.url)*/
    }
}
