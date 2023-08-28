package com.lapvt.myapplication.btvn_b5.bai2

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lapvt.myapplication.R

class Btvn5B2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_btvn5_b2)

        val rcvData: RecyclerView = findViewById(R.id.rcvData)

        val adapter = PersonAdapter(createPersonList())
        rcvData.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rcvData.adapter = adapter
        adapter.onClickItem = {
            Toast.makeText(this, it.getData(), Toast.LENGTH_SHORT).show()
        }
    }

    public fun createPersonList(): ArrayList<PersonData> {
        val personList: ArrayList<PersonData> = ArrayList()
        personList.add(PersonData(BitmapFactory.decodeResource(resources, R.drawable.ic_friend1), "James", "Thank you! That was very helpful!"))
        personList.add(PersonData(BitmapFactory.decodeResource(resources, R.drawable.ic_friend2), "Will Kenny", "I know... I’m trying to get the funds."))
        personList.add(PersonData(BitmapFactory.decodeResource(resources, R.drawable.ic_friend1), "James", "Thank you! That was very helpful!"))
        personList.add(PersonData(BitmapFactory.decodeResource(resources, R.drawable.ic_friend2), "Will Kenny", "I know... I’m trying to get the funds."))
        return personList
    }
}