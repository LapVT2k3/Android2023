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
    var count3 = 0f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        println(tinhTich(3, 5))
        println(tinhThuong(5))

        val student = StudentKotlin()
        // Set dữ liệu
        student.name = "Vũ Trung Lập"
        student.age = 20
    }

    private fun logExample(result: String, result2: String) {

    }

    private fun tinhTich(a: Int, b: Int): Int {
        return a.times(b)
    }

    // Trong trường hợp không truyền giá trị của b thì giá trị của b mặc định là 1
    // Trong trường hợp có dấu ? nghĩa là giá trị của biến đó có thể là null
    private fun tinhThuong(a: Int?,  b: Int = 1): Int? {
        return a?.div(b);
    }

    private fun tinhTong(a: Int, b: Int) = a + b
}