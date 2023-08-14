package com.lapvt.myapplication.btvn_b5.bai3

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.lapvt.myapplication.R

class Btvn5B3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_btvn5_b3)

        val rcvData: RecyclerView = findViewById(R.id.rcvData)


    }

    private fun creatImageList(): List<ImageData> {
        val imageList: ArrayList<ImageData> = ArrayList()
        imageList.add(ImageData(BitmapFactory.decodeResource(resources, R.drawable.ic_dog1)))
        imageList.add(ImageData(BitmapFactory.decodeResource(resources, R.drawable.ic_dog2)))
        imageList.add(ImageData(BitmapFactory.decodeResource(resources, R.drawable.ic_dog1)))
        imageList.add(ImageData(BitmapFactory.decodeResource(resources, R.drawable.ic_dog2)))
        imageList.add(ImageData(BitmapFactory.decodeResource(resources, R.drawable.ic_dog1)))
        imageList.add(ImageData(BitmapFactory.decodeResource(resources, R.drawable.ic_dog2)))
        imageList.add(ImageData(BitmapFactory.decodeResource(resources, R.drawable.ic_dog1)))
        imageList.add(ImageData(BitmapFactory.decodeResource(resources, R.drawable.ic_dog2)))
        return imageList
    }
}