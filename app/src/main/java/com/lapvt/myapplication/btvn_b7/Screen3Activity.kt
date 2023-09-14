package com.lapvt.myapplication.btvn_b7

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.lapvt.myapplication.R

class Screen3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen3)

        val tvCancel: TextView = findViewById(R.id.tvCancel)
        val tvSave: TextView = findViewById(R.id.tvSave)
        val edtTitle: EditText = findViewById(R.id.edtTitle)
        val edtContent: EditText = findViewById(R.id.edtContent)
        val message = intent.extras?.get("key2") as? MessageData
        var textTitle = message?.title
        var textContent = message?.content
        val index = intent.extras?.getInt("index")
        edtTitle.setText(message?.title)
        edtContent.setText(message?.content)

        tvSave.setTextColor(Color.parseColor("#8E97AA"))
        tvSave.isEnabled = false

        tvCancel.setOnClickListener {
            val intent = Intent()
            setResult(RESULT_OK, intent)
            finish()
        }

        edtTitle.addTextChangedListener {
            textTitle = it.toString().trim()
            tvSave.isEnabled = textTitle!!.isNotEmpty() && textContent!!.isNotEmpty()
            if (tvSave.isEnabled) {
                tvSave.setTextColor(Color.parseColor("#007AFF"))
            } else {
                tvSave.setTextColor(Color.parseColor("#8E97AA"))
            }
        }

        edtContent.addTextChangedListener {
            textContent = it.toString().trim()
            tvSave.isEnabled = textTitle!!.isNotEmpty() && textContent!!.isNotEmpty()
            if (tvSave.isEnabled) {
                tvSave.setTextColor(Color.parseColor("#007AFF"))
            } else {
                tvSave.setTextColor(Color.parseColor("#8E97AA"))
            }
        }

        tvSave.setOnClickListener {
            val intent = Intent()
            intent.putExtra("key3",
                message?.image?.let { it1 -> MessageData(it1, textTitle, textContent) })
            intent.putExtra("idx", index)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}