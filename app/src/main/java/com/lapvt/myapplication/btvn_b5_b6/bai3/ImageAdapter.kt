package com.lapvt.myapplication.btvn_b5_b6.bai3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.lapvt.myapplication.R

class ImageAdapter(private val imageList: List<ImageData>): RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    var onClickItem: ((ImageData) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dog, parent, false)
        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (imageList.isNotEmpty()) imageList.size else 0
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.setData(imageList[position])
        holder.itemView.setOnClickListener {
            onClickItem?.invoke(imageList[position])
        }
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imvDog: ImageView = itemView.findViewById(R.id.imvDog)

        public fun setData(image: ImageData) {
            imvDog.setImageBitmap(image.bitmap)
        }
    }
}