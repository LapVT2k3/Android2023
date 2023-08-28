package com.lapvt.myapplication.btvn_b5_b6.bai3

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lapvt.myapplication.R
import com.lapvt.myapplication.btvn_b5_b6.bai2.getData

class Btvn5B3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_btvn5_b3)

        val rcvData: RecyclerView = findViewById(R.id.rcvData)

        val adapter = ImageAdapter(creatImageList())
        rcvData.layoutManager = GridLayoutManager(this, 3)
        rcvData.addItemDecoration(GridSpacingItemDecoration(3, 50, true))
        rcvData.adapter = adapter
        adapter.onClickItem = {
            Toast.makeText(this, it.getData(), Toast.LENGTH_SHORT).show()
        }
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