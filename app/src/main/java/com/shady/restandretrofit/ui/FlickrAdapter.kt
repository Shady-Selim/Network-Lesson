package com.shady.restandretrofit.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shady.restandretrofit.R
import com.shady.restandretrofit.data.models.FlickrPhoto

class FlickrAdapter(val photosData: List<FlickrPhoto>) : RecyclerView.Adapter<CustomHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.flickr_recycleview_item, parent, false)
        return CustomHolder(view)
    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
        val photo = photosData[position]
        holder.titleTV.text = photo.title
    }

    override fun getItemCount(): Int {
        return photosData.size
    }

}

class CustomHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleTV: TextView = itemView.findViewById(R.id.tvFlickr)
    val imageIV: ImageView = itemView.findViewById(R.id.ivFlickr)
}
