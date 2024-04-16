package com.msid.photostypicode.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.msid.photostypicode.R

class PhotosAdapter(private val photos: List<PhotosItem>) : RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photos,parent,false)
        return PhotosViewHolder(view)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        holder.bind(photos[position])


    }


    class PhotosViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(photosItem: PhotosItem) {
            textViewId.text=photosItem.id.toString()
            textViewTitle.text=photosItem.title

            // Load image using Glide
                    Glide.with(itemView)
                        .load(photosItem.url) // Replace imageUrl with your actual image URL field
                        .into(imageView2)

        }


        private val textViewId:TextView = itemView.findViewById(R.id.textViewId)
        private val textViewTitle:TextView = itemView.findViewById(R.id.textViewTitle)
        private val imageView2 : ImageView = itemView.findViewById(R.id.imageView2)



    }
}