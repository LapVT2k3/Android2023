package com.lapvt.myapplication.btvn_b5.bai3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.lapvt.myapplication.R

class ImageAdapter(private val imageList: List<ImageData>): RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dog, parent, false)
        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.setData(imageList.get(position))
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imvDog: ImageView = itemView.findViewById(R.id.imvDog)

        public fun setData(image: ImageData) {
            imvDog.setImageBitmap(image.bitmap)
        }
    }
}