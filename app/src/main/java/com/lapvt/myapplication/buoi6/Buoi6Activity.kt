package com.lapvt.myapplication.buoi6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lapvt.myapplication.R

class Buoi6Activity : AppCompatActivity() {

    // Lambda function
    // (Kiểu dữ liệu) -> Unit
    // Kiểu dữ liệu có thể có hoặc không
    private var print: (() -> Unit) = {
        Toast.makeText(this, "hihi", Toast.LENGTH_SHORT).show()
    }
    private var print2: ((String) -> Unit) = {
        Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buoi6)
        print2.invoke("lập")
//        tinhTong(1, 2)
    }
}