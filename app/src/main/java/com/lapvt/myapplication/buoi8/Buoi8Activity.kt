package com.lapvt.myapplication.buoi8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.lapvt.myapplication.R

class Buoi8Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buoi8)

        val edtName = findViewById<EditText>(R.id.edtName)
        val tvName = findViewById<TextView>(R.id.tvName)
        val btnSave = findViewById<Button>(R.id.btnSave)
        // Lấy dữ liệu name được lưu ở local và set ở textView
        tvName.text = SharePreferencesUtils.getName(this)

        btnSave.setOnSingleClick {
//            val name = edtName.text.toString().trim()
//            SharePreferencesUtils.saveName(name, this)
//
//            // Lấy dữ liệu name được lưu ở local và set ở textView
//            tvName.text = SharePreferencesUtils.getName(this)

            AppRoomDatabase.getDatabase(this).userProfileDao().insert(UserProfile(
                name = "Vũ Trung Lập ${System.currentTimeMillis()}",
                age = 20,
                gender = "Nam",
                height = "165",
                weight = "63"
            ))

            tvName.text = AppRoomDatabase.getDatabase(this).userProfileDao().getAllUsers().toString()
        }
        tvName.text = AppRoomDatabase.getDatabase(this).userProfileDao().getAllUsers().toString()

    }
}