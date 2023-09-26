package com.lapvt.myapplication.btvn_b8

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.lapvt.myapplication.R

class B8Screen3Activity : AppCompatActivity() {
    private var edtName3: EditText? = null
    private var edtAddress3: EditText? = null
    private var edtPhone3: EditText? = null
    private var btnSave3: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b8_screen3)

        edtName3 = findViewById(R.id.edtName3)
        edtAddress3 = findViewById(R.id.edtAddress3)
        edtPhone3 = findViewById(R.id.edtPhone3)
        btnSave3 = findViewById(R.id.btnSave3)
        var textName = ""
        var textAddress = ""
        var textPhone = ""

        btnSave3?.setBackgroundColor(Color.parseColor("#8E97AA"))
        btnSave3?.isEnabled = false

        edtName3?.addTextChangedListener {
            textName = it.toString().trim()
            btnSave3?.isEnabled = textName.isNotEmpty()
                    && textAddress.isNotEmpty() && textPhone.isNotEmpty()
            if (btnSave3?.isEnabled == true) {
                btnSave3?.setBackgroundColor(Color.parseColor("#1F9FFC"))
            } else {
                btnSave3?.setBackgroundColor(Color.parseColor("#8E97AA"))
            }
        }

        edtAddress3?.addTextChangedListener {
            textAddress = it.toString().trim()
            btnSave3?.isEnabled = textName.isNotEmpty()
                    && textAddress.isNotEmpty() && textPhone.isNotEmpty()
            if (btnSave3?.isEnabled == true) {
                btnSave3?.setBackgroundColor(Color.parseColor("#1F9FFC"))
            } else {
                btnSave3?.setBackgroundColor(Color.parseColor("#8E97AA"))
            }
        }

        edtPhone3?.addTextChangedListener {
            textPhone = it.toString().trim()
            btnSave3?.isEnabled = textName.isNotEmpty()
                    && textAddress.isNotEmpty() && textPhone.isNotEmpty()
            if (btnSave3?.isEnabled == true) {
                btnSave3?.setBackgroundColor(Color.parseColor("#1F9FFC"))
            } else {
                btnSave3?.setBackgroundColor(Color.parseColor("#8E97AA"))
            }
        }

        btnSave3?.setOnClickListener {
            val user = UserData(textName, textAddress, textPhone)
            val intent = Intent()
            intent.putExtra("user_added", user)
            intent.putExtra(B8Screen1Activity.KEY, B8Screen1Activity.TYPE_ADD)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}