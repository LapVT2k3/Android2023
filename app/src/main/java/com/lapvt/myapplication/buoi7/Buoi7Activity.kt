package com.lapvt.myapplication.buoi7

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.lapvt.myapplication.R

class Buoi7Activity : AppCompatActivity() {
    private var flFragment1: FrameLayout? = null
    private var btnOpen: Button? = null
    var so: String = ""

    // Truyền ngược từ màn Buoi7Hai về màn Buoi7
    // Dùng khi cần gọi đến các thứ mặc định trong máy (ví dụ: chọn ảnh, chụp ảnh...)
    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val so = result.data?.extras?.getInt("key4")
                Toast.makeText(this, "$so", Toast.LENGTH_SHORT).show()
            }
    }

    // Khởi tạo, findViewById, chỉ được gọi 1 lần (call api)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buoi7)

        flFragment1 = findViewById(R.id.flFragment1)
        btnOpen = findViewById(R.id.btnOpen)

        val fragment1 = Buoi7Fragment.newFragment("Đây là data")
        val fragmentManager = supportFragmentManager
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.add(R.id.flFragment1, fragment1, fragment1.tag).commitAllowingStateLoss()

        openNewScreen()
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

    fun toastSomething(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    private fun openNewScreen() {
        btnOpen?.setOnClickListener {
            val intent = Intent(this, Buoi7BarActivity::class.java)
            // Truyền dữ liệu kiểu int
            intent.putExtra("key1", 10)
            // Truyền dữ liệu kiểu string
            intent.putExtra("key2", "Tôi tên là Lập")

            val data = SevenData().apply {
                this.title = "Đây là title"
                this.content = "Đây là content"
            }
            intent.putExtra("key3", data)
//            startActivity(intent)
            startForResult.launch(intent)

        }
    }
}