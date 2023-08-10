package com.lapvt.myapplication.buoi5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lapvt.myapplication.R

class KotlinActivity : AppCompatActivity() {

    val count: Int = 0
    // Biến var có giá trị mặc định
    var count1: Int = 0
    // Biến var không gán giá trị mặc định
    var count2: Int? = null
    // Không khai báo kiểu dữ liệu
    var count3 = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

    }

    private fun logExample(result: String, result2: String) {

    }

    private fun tinhTong(a: Int, b: Int): Int {
//        return a + b;
        return a.times(b)
    }
}