package com.lapvt.myapplication.btvn_b5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.lapvt.myapplication.R

class Btvn5B2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_btvn5_b2)

        val rcvData: RecyclerView = findViewById(R.id.rcvData)

        val adapter: PersonAdapter = PersonAdapter()
    }

    public fun createPersonList(): List<PersonData> {
        val personList: ArrayList<PersonData> = ArrayList()
//        personList.add()
    }
}