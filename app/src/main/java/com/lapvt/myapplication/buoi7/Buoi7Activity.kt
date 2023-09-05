package com.lapvt.myapplication.buoi7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import com.lapvt.myapplication.R

class Buoi7Activity : AppCompatActivity() {
    private var flFragment1: FrameLayout? = null
    private var flFragment2: FrameLayout? = null


    // Khởi tạo, findViewById, chỉ được gọi 1 lần (call api)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buoi7)
        flFragment1 = findViewById(R.id.flFragment1)
//        flFragment2 = findViewById(R.id.flFragment2)

        val fragment1 = Buoi7Fragment()
//        val fragment2 = Buoi7HaiFragment()

        val fragmentManager = supportFragmentManager
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.add(R.id.flFragment1, fragment1, fragment1.tag).commitAllowingStateLoss()
//        fragmentTransition.add(R.id.flFragment2, fragment2)
    }

    // Được gọi nhiều lần
    override fun onStart() {
        super.onStart()
    }
    // Sau hàm onResume, chúng ta có thể thấy màn hình
    // Được gọin nhiều lần, chúng ta có thể xử lý một số logic cần khi app quay trở về foreground
    override fun onResume() {
        super.onResume()
    }
    // Khi app được xuống background (cần lưu lại một số dữ liệu gì đó
    // để khi app từ background lên foreground thì nó hiển thị luôn)
    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onRestart() {
        super.onRestart()
    }
    // Hủy activity (hệ thống android kill app, chúng ta gọi)
    // Remove hoặc clear một số observe, 1 số luồng call api dang dở, 1 số sự kiện khác
    // -> Tiết kiệm bộ nhớ, tránh bị leak memory
    override fun onDestroy() {
        super.onDestroy()
    }

    fun toastSomething() {
        Toast.makeText(this, "haha", Toast.LENGTH_SHORT).show()
    }
}