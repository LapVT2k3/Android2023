package com.lapvt.myapplication.btvn_b7

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.lapvt.myapplication.R

class Screen2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen2)

        val tvCancel: TextView = findViewById(R.id.tvCancel)
        val tvSave: TextView = findViewById(R.id.tvSave)
        val edtTitle: EditText = findViewById(R.id.edtTitle)
        val edtContent: EditText = findViewById(R.id.edtContent)
        var textTitle = ""
        var textContent = ""

        tvSave.setTextColor(Color.parseColor("#8E97AA"))
        tvSave.isEnabled = false

        tvCancel.setOnClickListener {
            val intent = Intent()
            setResult(RESULT_OK, intent)
            finish()
        }

        edtTitle.addTextChangedListener {
            textTitle = it.toString().trim()
            tvSave.isEnabled = textTitle.isNotEmpty() && textContent.isNotEmpty()
            if (tvSave.isEnabled) {
                tvSave.setTextColor(Color.parseColor("#007AFF"))
            } else {
                tvSave.setTextColor(Color.parseColor("#8E97AA"))
            }
        }

        edtContent.addTextChangedListener {
            textContent = it.toString().trim()
            tvSave.isEnabled = textTitle.isNotEmpty() && textContent.isNotEmpty()
            if (tvSave.isEnabled) {
                tvSave.setTextColor(Color.parseColor("#007AFF"))
            } else {
                tvSave.setTextColor(Color.parseColor("#8E97AA"))
            }
        }

        tvSave.setOnClickListener {
            val intent = Intent()
            intent.putExtra("key1", MessageData(R.drawable.ic_message, textTitle, textContent))
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }
}