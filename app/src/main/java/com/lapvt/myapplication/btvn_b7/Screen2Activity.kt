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
    private var tvCancel: TextView? = null
    private var tvSave: TextView? = null
    private var edtTitle: EditText? = null
    private var edtContent: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen2)

        tvCancel = findViewById(R.id.tvCancel)
        tvSave = findViewById(R.id.tvSave)
        edtTitle = findViewById(R.id.edtTitle)
        edtContent = findViewById(R.id.edtContent)
        var textTitle = ""
        var textContent = ""

        tvSave?.setTextColor(Color.parseColor("#8E97AA"))
        tvSave?.isEnabled = false

        tvCancel?.setOnClickListener {
            val intent = Intent()
            setResult(RESULT_OK, intent)
            finish()
        }

        edtTitle?.addTextChangedListener {
            textTitle = it.toString().trim()
            tvSave?.isEnabled = textTitle.isNotEmpty() && textContent.isNotEmpty()
            if (tvSave?.isEnabled == true) {
                tvSave?.setTextColor(Color.parseColor("#007AFF"))
            } else {
                tvSave?.setTextColor(Color.parseColor("#8E97AA"))
            }
        }

        edtContent?.addTextChangedListener {
            textContent = it.toString().trim()
            tvSave?.isEnabled = textTitle.isNotEmpty() && textContent.isNotEmpty()
            if (tvSave?.isEnabled == true) {
                tvSave?.setTextColor(Color.parseColor("#007AFF"))
            } else {
                tvSave?.setTextColor(Color.parseColor("#8E97AA"))
            }
        }

        tvSave?.setOnClickListener {
            val message = MessageData(
                System.currentTimeMillis().toInt(),
                R.drawable.ic_message,
                textTitle,
                textContent
            )
            val intent = Intent()
            intent.putExtra("message", message)
            intent.putExtra(Screen1Activity.KEY, Screen1Activity.TYPE_ADD)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }
}