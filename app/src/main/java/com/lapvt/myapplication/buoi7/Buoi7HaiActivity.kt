package com.lapvt.myapplication.buoi7

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.lapvt.myapplication.R

class Buoi7HaiActivity : AppCompatActivity() {
    // Hiển thị dữ liệu từ màn trước chuyển sang
    private var tvShowData: TextView? = null
    // Bấm vào sẽ back là màn trước và truyền dữ liệu ngược lại
    private var btnBack: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buoi7_hai)
        tvShowData = findViewById(R.id.tvShowData)
        btnBack = findViewById(R.id.btnBack)

        // Nhận dữ liệu
        val num = intent.extras?.getInt("key1", -1)
        val text = intent.extras?.getString("key2", "")
        val data = intent.extras?.get("key3") as? SevenData

        val textString = "$text _ $num\n${data?.title}\n${data?.content}"
        tvShowData?.text = textString

        btnBack?.setOnClickListener {
            val intent = Intent()
            intent.putExtra("key4", 1)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}