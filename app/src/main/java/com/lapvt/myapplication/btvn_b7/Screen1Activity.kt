package com.lapvt.myapplication.btvn_b7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lapvt.myapplication.R

class Screen1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen1)


    }

    public fun createItemList(): ArrayList<ItemData> {
        val itemList: ArrayList<ItemData> = ArrayList()

    }
}