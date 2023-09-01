package com.lapvt.myapplication.buoi7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lapvt.myapplication.R

class Buoi7Activity : AppCompatActivity() {
    // Khởi tạo, findViewById, chỉ được gọi 1 lần (call api)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buoi7)
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
}